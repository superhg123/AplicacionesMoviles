package com.example.httprequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.httprequest.request.User;

import java.util.List;

public class Adaptador extends BaseAdapter {
    Context contexto;
    LayoutInflater inflador;
    List<User> usuarios;

    public Adaptador(List<User> usuarios, Context contexto) {
        this.usuarios = usuarios;
        this.contexto = contexto;
        this.inflador = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return usuarios.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflador.inflate(R.layout.listita, null);
        TextView username = view.findViewById(R.id.usernameListita), data = view.findViewById(R.id.dataListita);
        User actual = usuarios.get(i);
        username.setText(actual.getName());
        data.setText(String.format("%s %s %s", actual.getNombre(), actual.getPaterno(), actual.getCorreo()));
        return view;
    }
}
