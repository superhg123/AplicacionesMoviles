package com.example.prctica3;

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

    EditText duracioncita;
    Button botoncitoLocal;
    Button botoncitoNacional;
    Button botoncitoInternacional;
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
        duracioncita = findViewById(R.id.duracioncita);
        botoncitoLocal = findViewById(R.id.botoncitoLocal);
        botoncitoNacional = findViewById(R.id.botoncitoNacional);
        botoncitoInternacional = findViewById(R.id.botoncitoInternacional);

        Cuota cuotita = new Cuota();

        botoncitoLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cuotita.setDuracion(Integer.parseInt(duracioncita.getText().toString()));
                    Toast.makeText(cont, "El precio de la llamada sera de $" + cuotita.local(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(cont, "Formato invalido", Toast.LENGTH_LONG).show();
                }
            }
        });

        botoncitoNacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cuotita.setDuracion(Integer.parseInt(duracioncita.getText().toString()));
                    Toast.makeText(cont, "El precio de la llamada sera de $" + String.valueOf(cuotita.nacional()), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(cont, "Formato invalido", Toast.LENGTH_LONG).show();
                }
            }
        });

        botoncitoInternacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cuotita.setDuracion(Integer.parseInt(duracioncita.getText().toString()));
                    Toast.makeText(cont, "El precio de la llamada sera de $" + cuotita.internacional(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(cont, "Formato invalido", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}