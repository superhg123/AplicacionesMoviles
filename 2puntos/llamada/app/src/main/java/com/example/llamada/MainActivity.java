package com.example.llamada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText textito;
    Button local, nac, inter;

    public void mandarMensaje(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }

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
        textito = findViewById(R.id.textito);

        local = findViewById(R.id.local);
        nac = findViewById(R.id.nac);
        inter = findViewById(R.id.inter);

        Clasesita objetito = new Clasesita();


        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mandarMensaje("$" + objetito.local(Integer.parseInt(textito.getText().toString())));
                } catch (Exception e) {
                    mandarMensaje("Formato invalido");
                }
            }
        });

        nac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mandarMensaje("$" + objetito.nacional(Integer.parseInt(textito.getText().toString())));
                } catch (Exception e) {
                    mandarMensaje("Formato invalido");
                }
            }
        });

        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mandarMensaje("$" + objetito.internacional(Integer.parseInt(textito.getText().toString())));
                } catch (Exception e) {
                    mandarMensaje("Formato invalido");
                }
            }
        });
    }
}