package com.example.practica4;

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

    Button botoncito;
    EditText textito;
    int n = 0;

    public void desplegarTexto(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
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

        botoncito = findViewById(R.id.botoncito);
        textito = findViewById(R.id.textito);

        botoncito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    n = Integer.parseInt(textito.getText().toString());
                } catch (Exception e) {
                    desplegarTexto("Formato invalido");
                    e.printStackTrace(System.out);
                }
                if (n > 0 && n <= 15) {
                    if (n > 8) {
                        if (n > 12) {
                            if (n > 14) {
                                desplegarTexto("Quince");
                            } else {
                                if (n > 13) {
                                    desplegarTexto("Catorce");
                                } else {
                                    desplegarTexto("Trece");
                                }
                            }
                        } else {
                            if (n > 11) {
                                desplegarTexto("Doce");
                            } else {
                                if(n > 10) {
                                    desplegarTexto("Once");
                                } else {
                                    if (n > 9) {
                                        desplegarTexto("Diez");
                                    } else {
                                        desplegarTexto("Nueve");
                                    }
                                }
                            }
                        }
                    } else {
                        if (n > 6) {
                            if (n > 7) {
                                desplegarTexto("Ocho");
                            } else {
                                desplegarTexto("Siete");
                            }
                        } else {
                            if (n > 2) {
                                if (n > 4) {
                                    if (n > 5) {
                                        desplegarTexto("Seis");
                                    } else {
                                        desplegarTexto("Cinco");
                                    }
                                } else {
                                    if (n > 3) {
                                        desplegarTexto("Cuatro");
                                    } else {
                                        desplegarTexto("Tres");
                                    }
                                }
                            } else {
                                if (n > 1) {
                                    desplegarTexto("Dos");
                                } else {
                                    desplegarTexto("Uno");
                                }
                            }
                        }
                    }
                } else {
                    desplegarTexto("Dato Erroneo");
                }

            }
        });

    }
}