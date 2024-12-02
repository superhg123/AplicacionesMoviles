package com.example.proyectitofinal.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.proyectitofinal.R;

public class SpinnerAdapter extends BaseAdapter {

    String[] lista;
    Context context;
    LayoutInflater inflater;

    public SpinnerAdapter(String[] lista, Context context) {
        this.lista = lista;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int i) {
        return lista[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vistita = inflater.inflate(R.layout.spinneradapter, null);
        TextView texto = vistita.findViewById(R.id.textito);
        texto.setText(lista[i]);
        return vistita;
    }
}
