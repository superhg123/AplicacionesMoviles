package com.example.completito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Actividad> actividades;
    private LayoutInflater inflador;
    private Context context;

    public Adaptador(ArrayList<Actividad> actividades, Context context) {
        this.actividades = actividades;
        this.context = context;
        this.inflador = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return actividades.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflador.inflate(R.layout.basurita, null);
        Actividad actActual = this.actividades.get(position);
        TextView titulo = convertView.findViewById(R.id.titulo),
                subtitulo = convertView.findViewById(R.id.subtitulo),
                fecha = convertView.findViewById(R.id.fecha);
        ImageView imageView = convertView.findViewById(R.id.imagen);
        imageView.setImageResource(actActual.getImagen());
        titulo.setText(actActual.getTitulo());
        subtitulo.setText(actActual.getSubtitulo());
        fecha.setText(actActual.getFecha());
        return convertView;
    }
}
