package com.example.combobox;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText datito1, datito2;
    Button botoncito;
    Spinner spinsito;

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

        datito1 = findViewById(R.id.datito1);
        datito2 = findViewById(R.id.datito2);

        botoncito = findViewById(R.id.botoncito);

        spinsito = findViewById(R.id.spinsito);

        String[] arreglito = {"Selecciona una opcion", "Cuadrado", "Triangulo", "Rectangulo"};
        ArrayAdapter<String> adaptadorsito = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arreglito);

        spinsito.setAdapter(adaptadorsito);
        spinsito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (spinsito.getSelectedItem().toString()) {
                    case "Selecciona una opcion":
                        botoncito.setEnabled(false);
                        datito1.setEnabled(false);
                        datito2.setEnabled(false);
                        break;
                    case "Cuadrado":
                        botoncito.setEnabled(true);
                        datito1.setEnabled(true);
                        datito2.setEnabled(false);
                        break;

                    case "Triangulo":
                    case "Rectangulo":
                        botoncito.setEnabled(true);
                        datito1.setEnabled(true);
                        datito2.setEnabled(true);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        botoncito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    switch (spinsito.getSelectedItem().toString()) {
                        case "Cuadrado":
                            Operador op = new Operador(Integer.parseInt(datito1.getText().toString()));
                            Toast.makeText(MainActivity.this, "El area es de " + op.cuadrado() + " m2", Toast.LENGTH_SHORT).show();
                            break;
                        case "Triangulo":
                            op = new Operador(Integer.parseInt(datito1.getText().toString()), Integer.parseInt(datito2.getText().toString()));
                            Toast.makeText(MainActivity.this, "El area es de " + op.triangulo() + " m2", Toast.LENGTH_SHORT).show();
                            break;
                        case "Rectangulo":
                            op = new Operador(Integer.parseInt(datito1.getText().toString()), Integer.parseInt(datito2.getText().toString()));
                            Toast.makeText(MainActivity.this, "El area es de " + op.rectangulo() + " m2", Toast.LENGTH_SHORT).show();
                            break;
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Entrada invalida", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}