package com.example.prctica2;

import android.content.Context;
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

    Button boton;
    Button botoncito;
    EditText texto;
    Context cont = this;
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
    boton = findViewById(R.id.boton);
    botoncito = findViewById(R.id.botoncito);
    texto = findViewById(R.id.texto);
    Clasesita clasesita = new Clasesita();
    boton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                clasesita.setDatito(Integer.parseInt(texto.getText().toString()));
                Toast.makeText(cont, String.valueOf(clasesita.doble()), Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(cont, "Formato invalido", Toast.LENGTH_LONG).show();
            }

        }
    });

    botoncito.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                clasesita.setDatito(Integer.parseInt(texto.getText().toString()));
                Toast.makeText(cont, String.valueOf(clasesita.triple()), Toast.LENGTH_LONG).show();
            } catch (Exception e){
                Toast.makeText(cont, "Formato invalido", Toast.LENGTH_LONG).show();
            }
        }
    });

    }
}