package com.example.kks;

public class Keka {
    private int tipo;
    private int precio;
    private int cantidad;

    public Keka(int cantidad, int tipo) {
        this.cantidad = cantidad;
        this.tipo = tipo;
        if(tipo == 1) precio=cantidad*15;
        if (tipo == 2) precio=cantidad*20;
        if (tipo == 3) precio=cantidad*25;
    }

    public static int getTipo(String keka) {
        int retorno;
        if (keka.equals("papa")) retorno = 1;
        else if (keka.equals("queso")) retorno = 2;
        else if (keka.equals("picadillo")) retorno = 3;
        else retorno = -1;
        return retorno;
    }

    public int getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public static String getTipo(int tipo) {
        if (tipo == 1) return "papa";
        if (tipo == 2) return  "queso";
        if (tipo == 3) return  "picadillo";
        else return "no existe";


    }
}
