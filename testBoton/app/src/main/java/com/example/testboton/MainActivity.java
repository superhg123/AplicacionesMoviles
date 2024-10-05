package com.example.testboton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button boton1, boton2;
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
        boton1 = findViewById(R.id.botoncito1);
        boton2 = findViewById(R.id.botoncito2);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(((Button) view).getText().toString().equals("Boton 1"))
            Toast.makeText(this, "Hola Boton 1", Toast.LENGTH_SHORT).show();
        if(((Button) view).getText().toString().equals("Boton 2"))
            Toast.makeText(this, "Hola Boton 2", Toast.LENGTH_SHORT).show();
    }
}