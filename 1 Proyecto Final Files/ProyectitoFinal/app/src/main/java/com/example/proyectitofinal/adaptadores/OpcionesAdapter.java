package com.example.proyectitofinal.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.clases.Opcion;


import java.util.ArrayList;

public class OpcionesAdapter extends ArrayAdapter<String> {

    private ArrayList<Opcion> opciones;
    private LayoutInflater inflater;

    public OpcionesAdapter(Context context, int res, ArrayList<Opcion> opciones, ArrayList<String> strings) {
        super(context, res, strings);
        this.opciones = opciones;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = inflater.inflate(R.layout.opciones_adapter, null);
        }

        TextView texto = view.findViewById(R.id.valorOpcion);
        ImageView icono = view.findViewById(R.id.iconoOpcion);
        texto.setText(opciones.get(i).getValor());
        icono.setImageResource(opciones.get(i).getIcono());


        return view;
    }
}
