package com.example.proyectitofinal.listener;

import com.example.proyectitofinal.clases.Transaccion;

import java.util.ArrayList;

public interface DataChangedListener {
    public void onDataChanged(ArrayList<Transaccion> transacciones);
}
