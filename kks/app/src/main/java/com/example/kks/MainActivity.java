package com.example.kks;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spincito;
    Button carro, pay, del;
    EditText cantidad;
    Orden orden = new Orden();
    String[] kekas = {"Selecciona una opcion","papa", "queso", "picadillo"};
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
        carro = findViewById(R.id.carro);
        pay = findViewById(R.id.pay);
        del = findViewById(R.id.del);
        spincito = findViewById(R.id.spincito);
        cantidad = findViewById(R.id.cantidad);
        ArrayAdapter adaptadito = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, kekas);
        spincito.setAdapter(adaptadito);

        spincito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItem().toString().equals("Selecciona una opcion")) {
                    carro.setEnabled(false);
                } else {
                    carro.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        carro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Keka keka = new Keka(Integer.parseInt(cantidad.getText().toString()), Keka.getTipo(spincito.getSelectedItem().toString()));
                orden.agregarKeka(keka);
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Keka> ordenfinal = orden.regresarOrden();
                int total = 0;
                for(Keka x : ordenfinal) {
                    Toast.makeText(MainActivity.this, "De " + x.getCantidad() + " de " + Keka.getTipo(x.getTipo()) + " son $" + x.getPrecio(), Toast.LENGTH_SHORT).show();
                    total+= x.getPrecio();
                }
                Toast.makeText(MainActivity.this, "Total: $" + total, Toast.LENGTH_SHORT).show();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orden.nuevaOrden();
            }
        });


    }
}