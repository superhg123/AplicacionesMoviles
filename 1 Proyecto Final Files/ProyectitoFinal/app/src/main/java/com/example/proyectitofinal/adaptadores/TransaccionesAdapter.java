package com.example.proyectitofinal.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.clases.Transaccion;
import com.example.proyectitofinal.listener.DataChangedListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TransaccionesAdapter extends BaseAdapter {

    ArrayList<Transaccion> transacciones;
    Context context;
    LayoutInflater inflater;
    DataChangedListener listener;

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
        TextView fecha = vista.findViewById(R.id.fechaTransaccion);
        TextView monto = vista.findViewById(R.id.montoElemento);
        ImageView icono = vista.findViewById(R.id.iconTransaccion);

        switch (transacciones.get(i).getTipo()) {
            case "Vivienda":
                icono.setImageResource(R.drawable.vivienda_icon);
                break;
            case "Comida":
                icono.setImageResource(R.drawable.comida_icon);
                break;
            case "Transporte":
                icono.setImageResource(R.drawable.transporte_icon);
                break;
            case "Salud":
                icono.setImageResource(R.drawable.salud_icon);
                break;
            case "Entretenimiento":
                icono.setImageResource(R.drawable.entretenimiento_icon);
                break;
            case "Ropa y accesorios":
                icono.setImageResource(R.drawable.ropa_icon);
                break;
            case "Deuda":
                icono.setImageResource(R.drawable.deuda_icon);
                break;
            case "Educacion":
                icono.setImageResource(R.drawable.educacion_icon);
                break;
            case "Oscio":
                icono.setImageResource(R.drawable.oscio_icon);
                break;
            case "Salario":
                icono.setImageResource(R.drawable.money);
                break;
            case "Beca":
                icono.setImageResource(R.drawable.beca_icon);
                break;
            case "Ingreso pasivo":
                icono.setImageResource(R.drawable.pasivo_icon);
                break;
            case "Ganancias":
                icono.setImageResource(R.drawable.ganancia_icon);
                break;
            case "Subsidio":
                icono.setImageResource(R.drawable.subsidio_icon);
                break;
            case "Regalo":
                icono.setImageResource(R.drawable.regalo_icon);
                break;
            case "Premio":
                icono.setImageResource(R.drawable.premio_icon);
                break;
            case "Venta":
                icono.setImageResource(R.drawable.venta_icon);
                break;
            default:
                icono.setImageResource(R.drawable.fact_check);
                break;
        }


        titulo.setText(transacciones.get(i).getTitulo());
        desc.setText(transacciones.get(i).getDescripcion());
        monto.setText(String.format("%s $ %s", (transacciones.get(i).getIngreso()) ? "+" : "-", transacciones.get(i).getMonto()));
        fecha.setText(transacciones.get(i).getFecha());

        ImageView opcionesTransacion = vista.findViewById(R.id.opcionesTransaccion);
        opcionesTransacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transacciones.get(i).eliminarDeBase(context);
                transacciones.remove(i);
                listener.onDataChanged(transacciones);
            }
        });
        return vista;
    }

    public void setDataChangedListener(DataChangedListener listener) {
        this.listener = listener;
    }
}


