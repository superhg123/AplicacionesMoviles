package com.example.completito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Actividad> actividades = new ArrayList<>();
    ListView listita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listita = findViewById(R.id.listita);
        listita.setAdapter(new Adaptador(actividades, this));
        actividades.add(new Actividad(
                0,
                "Operaciones con menu",
                "Uso de menu fijo",
                "29 de octubre del 2024",
                new Intent(this, Operaciones.class)
        ));
        actividades.add(new Actividad(
                0,
                "Actividad 2",
                "Subtitulo 2",
                "29 de octubre del 2024",
                null
        ));
        actividades.add(new Actividad(
                0,
                "Actividad 3",
                "Subtitulo 3",
                "29 de octubre del 2024",
                null
        ));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listita.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(actividades.get(position).getIntentito());
            }
        });
    }
}