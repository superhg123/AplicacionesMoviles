package com.example.completito;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Operaciones extends AppCompatActivity {

    static EditText num1;
    static EditText num2;
    Button botoncito;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int num1 = Integer.parseInt(Operaciones.num1.getText().toString());
        int num2 = Integer.parseInt(Operaciones.num2.getText().toString());
        if(item.getItemId() == R.id.suma || item.getItemId() == R.id.iconSum) {
            Toast.makeText(this, + num1 + num2 + "", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == (R.id.resta) || item.getItemId() == R.id.iconRest) {
            Toast.makeText(this,  num1 - num2 + "", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mult || item.getItemId() == R.id.iconMult) {
            Toast.makeText(this, num1*num2 + "", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, num1/num2 + "", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operaciones);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        botoncito = findViewById(R.id.regreso);
        botoncito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentito = new Intent(Operaciones.this, MainActivity.class);
                startActivity(intentito);
            }
        });
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
    }


}