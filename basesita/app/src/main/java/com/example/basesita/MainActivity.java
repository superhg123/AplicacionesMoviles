package com.example.basesita;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText etcodigo, etdescripcion, etprecio;
        Button altas, bahjas, cambios, consultas;
        boolean truh = true;
        boolean fols = false;

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etcodigo = findViewById(R.id.eCodigo);
        etdescripcion = findViewById(R.id.eDescripcion);
        etprecio = findViewById(R.id.eprecio);

        altas = findViewById(R.id.altas);
        bahjas = findViewById(R.id.bajas);
        cambios = findViewById(R.id.cambios);
        consultas = findViewById(R.id.consultas);

        altas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!((Button)v).getText().toString().equals("Registrar")) {
                etcodigo.setEnabled(truh);
                etprecio.setEnabled(truh);
                etdescripcion.setEnabled(truh);
                bahjas.setEnabled(fols);
                cambios.setEnabled(fols);
                consultas.setEnabled(fols);
                ((Button) v).setText("Registrar");
                } else {
                    Base admin = new Base(MainActivity.this, "administracion", null,1);
                    SQLiteDatabase sicuel = admin.getWritableDatabase();
                    int llavesita = Integer.parseInt(etcodigo.getText().toString());
                    String titulito = etdescripcion.getText().toString();
                    int costito = Integer.parseInt(etprecio.getText().toString());
                    ContentValues registro = new ContentValues();
                    registro.put("clave", llavesita);
                    registro.put("descripcion", titulito);
                    registro.put("precio", costito);
                    sicuel.insert("cinecito", null, registro);
                    sicuel.close();
                    Toast.makeText(MainActivity.this, "Registro agregado", Toast.LENGTH_SHORT).show();
                }
        }});

        bahjas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        consultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}