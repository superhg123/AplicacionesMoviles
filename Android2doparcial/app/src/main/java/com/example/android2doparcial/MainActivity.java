package com.example.android2doparcial;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    View fragmentoIngreso;
    View fragmentoDesplegado;
    ListView listita;
    EditText titulo, subtitulo, contenido;
    Spinner colores;
    ArrayList<Elemento> elementos = new ArrayList<>();
    AdaptadorBasurita adaptador;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuapp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String stringTitulo = "", stringSubtitulo = "", stringContenido = "", colorsito = colores.getSelectedItem().toString();

        stringTitulo = titulo.getText().toString();

        if(item.getItemId() == R.id.completo) {
            stringSubtitulo = subtitulo.getText().toString();
            stringContenido = contenido.getText().toString();
        } else if (item.getItemId() == R.id.subtitulado) {
            stringSubtitulo = subtitulo.getText().toString();
        }

        elementos.add(new Elemento(stringTitulo, stringSubtitulo, stringContenido, colorsito));
        adaptador.notifyDataSetChanged();
        return true;
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
        fragmentoIngreso = findViewById(R.id.ingresoLayout);
        fragmentoDesplegado = findViewById(R.id.desplegadoLayout);

        adaptador = new AdaptadorBasurita(elementos, fragmentoDesplegado.getContext());
        listita = fragmentoDesplegado.findViewById(R.id.listado);
        listita.setAdapter(adaptador);

        titulo = fragmentoIngreso.findViewById(R.id.insertTitulo);
        subtitulo = fragmentoIngreso.findViewById(R.id.insertSub);
        contenido = fragmentoIngreso.findViewById(R.id.insertCont);
        colores = fragmentoIngreso.findViewById(R.id.colorSelect);
        String[] arreglito = {"Rojo", "Verde", "Azul"};
        colores.setAdapter(new ArrayAdapter<>(fragmentoIngreso.getContext(), android.R.layout.simple_spinner_dropdown_item, arreglito));

    }

}