package com.example.listitas;

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

public class MainActivity extends AppCompatActivity {
    String deportescomenta[] = {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};
    String deportes[] = {"Why so serious", "Chimalpopoca", "cholo", "Dr mario", "La molleja", "Maynez y Chochil mewing",
            ":0", "Hombre guapo", "Soy ese", "Taco man y su ayudante el churro"};
    int imagenes[] = {
            R.drawable.joker,
            R.drawable.chimalpopoca,
            R.drawable.cholo,
            R.drawable.drmario,
            R.drawable.lamolleja,
            R.drawable.mewing,
            R.drawable.ooo,
            R.drawable.roblox,
            R.drawable.soyese,
            R.drawable.tacoman
    };

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
        Adaptador adaptador = new Adaptador(this, deportes, deportescomenta, imagenes);
        ListView listita = findViewById(R.id.vistitas);
        listita.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" + (position+1), Toast.LENGTH_SHORT).show();
            }
        });
        listita.setAdapter(adaptador);

    }
}