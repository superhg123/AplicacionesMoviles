package com.example.proyectitofinal.clases;

public class Opcion {
    private String valor;
    private int icono;

    public Opcion(String valor, int icono) {
        this.valor = valor;
        this.icono = icono;
    }

    public String getValor() {
        return valor;
    }

    public int getIcono() {
        return icono;
    }
}
