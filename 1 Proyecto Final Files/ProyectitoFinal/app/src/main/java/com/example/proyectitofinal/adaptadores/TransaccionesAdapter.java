package com.example.proyectitofinal.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.clases.Transaccion;

import java.util.ArrayList;

public class TransaccionesAdapter extends BaseAdapter {

    ArrayList<Transaccion> transacciones;
    Context context;
    LayoutInflater inflater;

    public TransaccionesAdapter(ArrayList<Transaccion> transacciones, Context context) {
        this.transacciones = transacciones;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return transacciones.size();
    }

    @Override
    public Object getItem(int i) {
        return transacciones.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = inflater.inflate(R.layout.elemento_transaccion, null);
        TextView titulo = vista.findViewById(R.id.nombreTransaccion);
        TextView desc = vista.findViewById(R.id.descTransaccion);
        TextView monto = vista.findViewById(R.id.montoElemento);

        //titulo.setText(transacciones.get(i).getTitulo());
        //desc.setText(transacciones.get(i).getDescripcion());
        //monto.setText("$ " + transacciones.get(i).getMonto());
        return vista;
    }
}
