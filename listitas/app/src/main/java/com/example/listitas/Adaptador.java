package com.example.listitas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {
    Context contexto;
    String listadeportes[];
    String listacomentar[];
    int listaimagenes[];
    LayoutInflater inflater;

    public Adaptador(Context contexto, String listadeportes[], String[] listacomentar, int[] listaimagenes) {
        this.contexto = contexto;
        this.listadeportes = listadeportes;
        this.listacomentar = listacomentar;
        this.listaimagenes = listaimagenes;
        this.inflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount() {
        return listacomentar.length;
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
        convertView = inflater.inflate(R.layout.basurita, null);
        TextView textView = convertView.findViewById(R.id.textito);
        TextView textView2 = convertView.findViewById(R.id.textito2);
        ImageView deportImg = convertView.findViewById(R.id.imageicon);
        textView.setText(listadeportes[position]);
        textView2.setText(listacomentar[position]);
        deportImg.setImageResource(listaimagenes[position]);
        return convertView;
    }
}
