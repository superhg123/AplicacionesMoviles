package com.example.practica4;

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

    Context cont = this;
    EditText num1;
    EditText num2;
    Button suma;
    Button resta;
    Button mult;
    Button div;

    public void error() {
        Toast.makeText(this, "Formato invalido", Toast.LENGTH_LONG).show();
    }

    public void obtenerNumeros(Calculadora calculadora) {
        calculadora.setNum1(Integer.parseInt(num1.getText().toString()));
        calculadora.setNum2(Integer.parseInt(num2.getText().toString()));
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
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.rest);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);

        Calculadora calculadora = new Calculadora();

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    obtenerNumeros(calculadora);
                    Toast.makeText(cont, String.valueOf(calculadora.suma()), Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    error();
                }
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    obtenerNumeros(calculadora);
                    Toast.makeText(cont, String.valueOf(calculadora.resta()), Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    error();
                }
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    obtenerNumeros(calculadora);
                    Toast.makeText(cont, String.valueOf(calculadora.mult()), Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    error();
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    obtenerNumeros(calculadora);
                    Toast.makeText(cont, String.valueOf(calculadora.div()), Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    error();
                }
            }
        });


    }
}