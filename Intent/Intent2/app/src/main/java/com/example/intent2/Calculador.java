package com.example.intent2;

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

public class Calculador extends AppCompatActivity {

    Context cont = this;
    EditText input1, input2;
    Button cuad, rect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        input1 = findViewById(R.id.val1);
        input2 = findViewById(R.id.val2);
        cuad = findViewById(R.id.cuad);
        rect = findViewById(R.id.rect);

        cuad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Operador op = new Operador(Integer.parseInt(input1.getText().toString()));
                    Toast.makeText(cont, "El area del cuadrado es de " + op.cuadrado() + " m2", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(cont, "Entrada invalida", Toast.LENGTH_SHORT).show();
                }
                
            }
        });
        
        rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Operador op = new Operador(
                            Integer.parseInt(input1.getText().toString()),
                            Integer.parseInt(input2.getText().toString())
                    );
                    Toast.makeText(cont, "El area del rectangulo es de " + op.rectangulo() + " m2", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(cont, "Entrada invalida", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}