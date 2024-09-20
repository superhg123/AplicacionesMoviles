package com.example.arreglos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button guardar, mayor, menor, suma, promedio;
    EditText datito1, datito2, datito3;
    TextView textito;


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
        guardar = findViewById(R.id.guardar);
        mayor = findViewById(R.id.mayor);
        menor = findViewById(R.id.menor);
        suma = findViewById(R.id.suma);
        promedio = findViewById(R.id.promedio);

        datito1 = findViewById(R.id.datito1);
        datito2 = findViewById(R.id.datito2);
        datito3 = findViewById(R.id.datito3);

        textito = findViewById(R.id.textito);

        double[] arreglito = new double[3];
        Button[] botoncitos = {guardar, mayor, menor, suma, promedio};
        EditText[] datitos = {datito1, datito2, datito3};
        Clasesita objetito = new Clasesita();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datito1.getText().toString().isEmpty() || datito2.getText().toString().isEmpty() || datito3.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Faltan datos por llenar", Toast.LENGTH_SHORT).show();
                } else {
                    for(int i = 0; i < 5; i++) {
                        botoncitos[i].setEnabled(true);
                        if(i > 2) continue;
                        arreglito[i] = Double.parseDouble(datitos[i].getText().toString());
                        datitos[i].setText("");
                    }
                    textito.setText(String.format("{ %s , %s , %s }", arreglito[0], arreglito[1], arreglito[2]));
                    Toast.makeText(MainActivity.this, "Datos guardados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "El mayor es " + objetito.mayor(arreglito) , Toast.LENGTH_SHORT).show();
            }
        });

        menor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "El menor es " + objetito.menor(arreglito), Toast.LENGTH_SHORT).show();
            }
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "La suma es " + objetito.suma(arreglito), Toast.LENGTH_SHORT).show();
            }
        });

        promedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "El promedio es " + objetito.promedio(arreglito), Toast.LENGTH_SHORT).show();
            }
        });


    }
}