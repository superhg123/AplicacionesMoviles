package com.example.proyectitofinal.vistas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectitofinal.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;

import java.text.NumberFormat;
import java.util.Currency;

public class Estadisticas extends Fragment {

    private String clave;

    public static Estadisticas newInstance(String clave) {

        Bundle args = new Bundle();
        args.putString("Usuario", clave);
        Estadisticas fragment = new Estadisticas();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_estadisticas, container, false);
        String clave = getArguments().getString("Usuario");
        RangeSlider deslizador = vista.findViewById(R.id.deslizadoMeta);
        LabelFormatter formatter = new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {
                NumberFormat formato = NumberFormat.getCurrencyInstance();
                formato.setMaximumFractionDigits(2);
                formato.setCurrency(Currency.getInstance("MXN"));
                return formato.format(value);
            }
        };

        LinearProgressIndicator metaDiaria = vista.findViewById(R.id.progresoMeta);
        float progreso = ((float) 125 /2000)*100;
        metaDiaria.setProgressCompat((int)progreso, true);
        deslizador.setLabelFormatter(formatter);
        return vista;
    }
}