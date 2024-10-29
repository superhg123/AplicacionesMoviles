package com.example.httprequest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.httprequest.request.SocketService;
import com.example.httprequest.request.User;
import com.example.httprequest.request.UserService;


import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.StompClient;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> lista = new ArrayList<>();
    ListView listView;
    EditText uname, pass;
    Button sender, ws;
    TextView result;
    StompClient stompClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.password);
        sender = findViewById(R.id.botoncito);
        ws = findViewById(R.id.ws);
        result = findViewById(R.id.result);
        listView = findViewById(R.id.dataListita);
        Adaptador adaptador = new Adaptador(lista, this);
        listView.setAdapter(adaptador);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.70:8080/").addConverterFactory(GsonConverterFactory.create()).build();
        UserService service = retrofit.create(UserService.class);
        SocketService socketService = retrofit.create(SocketService.class);

        ws.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View view) {
                stompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, "ws://192.168.1.70:8080/register");
                stompClient.connect();
                try {
                    stompClient.topic("/topic/canal1").subscribe(message -> {
                        result.setText("Actualizacion recibida" + message.getPayload());
                    });
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                }
            }
        });


        sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<User> resultado = service.resultado(uname.getText().toString(), pass.getText().toString());
                resultado.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful() && response.body() != null) {
                            User usuario = response.body();
                            result.setText(usuario.getName());
                            lista.add(usuario);
                            adaptador.notifyDataSetChanged();

                        } else {
                            result.setText(String.valueOf(response.raw()));
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        result.setText(t.getMessage());
                    }
                });

            }
        });
    }


}