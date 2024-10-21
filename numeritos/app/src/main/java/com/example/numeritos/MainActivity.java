package com.example.numeritos;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText textito;
    TextView vistita;

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
        vistita = findViewById(R.id.vistita);
        textito.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                try {
                    String cadenita = textito.getText().toString();
                    int numerito = Integer.parseInt(cadenita);
                    if(cadenita.length() == 1)
                        vistita.setText(Clasesita.unidades(numerito));
                    if(cadenita.length() == 2)
                        vistita.setText(Clasesita.decenas(numerito));
                    if(cadenita.length() == 3)
                        vistita.setText(Clasesita.centenas(numerito));
                    if(cadenita.length() > 3)
                        vistita.setText(Clasesita.millas(numerito));

                } catch (Exception e) {
                    vistita.setText("Numero invalido");
                }
                return false;
            }
        });
    }
}