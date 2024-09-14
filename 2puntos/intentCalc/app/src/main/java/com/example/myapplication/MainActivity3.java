package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Context cont = this;
    EditText width, height;
    Button calc, reg;
    TextView resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        width = findViewById(R.id.width);
        height = findViewById(R.id.height);

        calc = findViewById(R.id.calc);
        reg = findViewById(R.id.reg);

        resul = findViewById(R.id.resul);

        Operador op = new Operador();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(op.triangulito(
                        width.getText().toString(),
                        height.getText().toString()
                ));
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentito = new Intent(cont, MainActivity.class);
                startActivity(intentito);
            }
        });
    }
}