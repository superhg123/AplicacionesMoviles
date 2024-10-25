package com.example.murisioncita;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText caracter;
    TextView solucion;
    Button sender;
    ImageView imagencita;
    static Clasesita gestor = new Clasesita();




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
        caracter = findViewById(R.id.caracter);
        solucion = findViewById(R.id.solucion);
        sender = findViewById(R.id.sender);
        imagencita = findViewById(R.id.imagencita);
        imagencita.setImageResource(0);


        sender.setOnClickListener(this);
        solucion.setText("Palabra a analizar: " + gestor.getResultado());
    }

    @Override
    public void onClick(View v) {
        if(sender.getText().equals("Enviar")) {
            String car = caracter.getText().toString();
            caracter.setText("");
            solucion.setText("Palabra a analizar: " + gestor.verificar(car));
            imagencita.setImageResource(gestor.verificarImagen());
            if(!solucion.getText().toString().contains("_")) {
                Toast.makeText(this, "Has ganado!", Toast.LENGTH_SHORT).show();
                sender.setText("Reiniciar");
            }
            if(gestor.getIntentos() == 6) {
                Toast.makeText(this, "Has perdido!, la palabra era " + gestor.getPalabra(), Toast.LENGTH_SHORT).show();
                sender.setText("Reiniciar");
            }
        }
        if(sender.getText().equals("Reiniciar")) {
            imagencita.setImageResource(0);
            gestor = new Clasesita();
            caracter.setText("");
            solucion.setText("Palabra a analzar: " + gestor.getResultado());
            sender.setText("Enviar");
        }

    }
}