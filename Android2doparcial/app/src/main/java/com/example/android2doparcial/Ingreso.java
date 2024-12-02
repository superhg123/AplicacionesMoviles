package com.example.android2doparcial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Ingreso extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_ingreso, container, false);
        EditText editTitulo = vista.findViewById(R.id.insertTitulo);
        EditText editSubt = vista.findViewById(R.id.insertSub);
        EditText editCont = vista.findViewById(R.id.insertCont);
        Spinner colores = vista.findViewById(R.id.colorSelect);
        String[] opcColores = {"Rojo", "Verde", "Azul"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(vista.getContext(), android.R.layout.simple_spinner_dropdown_item, opcColores);
        colores.setAdapter(adaptador);


        return vista;
    }
}