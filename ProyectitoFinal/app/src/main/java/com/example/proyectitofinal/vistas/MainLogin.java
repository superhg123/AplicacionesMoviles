package com.example.proyectitofinal.vistas;


import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proyectitofinal.R;

public class MainLogin extends Fragment {

    public MainLogin() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_main_login, container, false);
        Button iniciarSesionButton = vista.findViewById(R.id.iniciarSesionButton);
        Button registrarseButton = vista.findViewById(R.id.loginButton);
        registrarseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(MainLogin.this).navigate(R.id.action_mainLogin2_to_registrarse2);
            }
        });
        iniciarSesionButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    findNavController(MainLogin.this).navigate(R.id.action_mainLogin2_to_iniciarSesion22);
                }
            }
        );
        return vista;
    }
}