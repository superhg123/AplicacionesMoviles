package com.example.proyectitofinal.vistas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.modelo.Basesita;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;

import java.text.NumberFormat;
import java.util.ArrayList;
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
        Fragment thisFrag = this;
        Basesita admin = new Basesita(getContext(), "admin", null, 1);
        SQLiteDatabase reader = admin.getReadableDatabase();

        Cursor montoCursor = reader.rawQuery("SELECT monto, limite, meta from estadisticas WHERE id_usuario=?", new String[]{clave});

        montoCursor.moveToFirst();
        TextView montoStats = vista.findViewById(R.id.montoStats);
        montoStats.setText("$ " + montoCursor.getString(0));
        RangeSlider deslizador = vista.findViewById(R.id.deslizadoMeta);
        ArrayList<Float> sliderValues = new ArrayList<>();
        sliderValues.add(montoCursor.getFloat(1));
        sliderValues.add(montoCursor.getFloat(2));

        deslizador.setValues(sliderValues);
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


        float limiteActual = montoCursor.getFloat(1);

        Cursor acumuladoCursor = reader.rawQuery("SELECT sum(monto) FROM user_tracc INNER JOIN transaccion ON id_transaccion = user_tracc.transaccion WHERE usuario=?", new String[]{clave});
        acumuladoCursor.moveToFirst();
        float acumulado = acumuladoCursor.getFloat(0);

        LinearProgressIndicator metaDiaria = vista.findViewById(R.id.progresoMeta);
        float progreso = (acumulado/limiteActual)*100;
        metaDiaria.setProgressCompat((int)progreso, true);
        deslizador.setLabelFormatter(formatter);

        TextView leyenda = vista.findViewById(R.id.leyendavsStats);
        leyenda.setText(String.format("%s de %s", Math.round(acumulado * 100) / 100f + "", Math.round(limiteActual*100) / 100f + ""));

        Button enviarStats = vista.findViewById(R.id.enviar_stats);
        enviarStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Basesita admin = new Basesita(getContext(), "admin", null, 1);
                SQLiteDatabase dbs = admin.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("limite", deslizador.getValues().get(0));
                contentValues.put("meta", deslizador.getValues().get(1));
                dbs.update("estadisticas", contentValues, "id_usuario=?", new String[]{clave});
                getActivity().finish();
            }
        });
        return vista;
    }
}