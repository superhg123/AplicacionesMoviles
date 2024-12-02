package com.example.proyectitofinal.vistas;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.modelo.Basesita;

import java.util.Objects;


public class IniciarSesion extends Fragment {


    public IniciarSesion() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_iniciar_sesion, container, false);

        EditText claveLogin = vista.findViewById(R.id.claveLogin);
        Button ingresar = vista.findViewById(R.id.ingButton);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Basesita admin = new Basesita(getContext(), "admin", null, 1);
                    SQLiteDatabase sicuel = admin.getReadableDatabase();
                    String clave = claveLogin.getText().toString();
                    Cursor cursor = sicuel.rawQuery("SELECT * FROM usuario WHERE clave = " + clave, null);
                    if(cursor.moveToFirst()) {
                        Intent intentito = new Intent(getContext(), App.class);
                        startActivity(intentito);
                    } else {
                        throw new Exception();

                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(), "No se encontro el registro", Toast.LENGTH_SHORT).show();
                }


            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                findNavController(IniciarSesion.this).navigate(R.id.action_iniciarSesion2_to_mainLogin2);
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        return vista;
    }
}