package com.example.android2doparcial;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorBasurita extends BaseAdapter {
    private ArrayList<Elemento> elementos;
    private Context context;
    private LayoutInflater inflador;

    public AdaptadorBasurita(ArrayList<Elemento> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
        this.inflador = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int i) {
        return elementos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return elementos.get(i).getTitulo().hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflater = inflador.inflate(R.layout.basurita, null);
        TextView titulo = inflater.findViewById(R.id.titulo);
        TextView subtitulo = inflater.findViewById(R.id.subtitulo);
        TextView contenido = inflater.findViewById(R.id.contenido);
        Button placeholder = inflater.findViewById(R.id.placeholderImagen);
        Elemento thisElemento = elementos.get(i);

        titulo.setText(thisElemento.getTitulo());
        subtitulo.setText(thisElemento.getSubtitulo());
        contenido.setText(thisElemento.getContenido());

        if(thisElemento.getColor().equals("Rojo")) {
            placeholder.setBackgroundColor(Color.RED);
        } else if (thisElemento.getColor().equals("Verde")) {
            placeholder.setBackgroundColor(Color.GREEN);
        } else if (thisElemento.getColor().equals("Azul")) {
            placeholder.setBackgroundColor(Color.BLUE);
        }


        return inflater;
    }
}
