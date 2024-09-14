package com.example.myapplication;

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

public class MainActivity2 extends AppCompatActivity {

    Context cont = this;
    TextView area;
    Button calc, reg;
    EditText radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        area =  findViewById(R.id.resul);

        calc = findViewById(R.id.calc);
        reg =  findViewById(R.id.reg);

        radio = findViewById(R.id.radio);

        Operador op = new Operador();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                area.setText(op.circulito(radio.getText().toString()));
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