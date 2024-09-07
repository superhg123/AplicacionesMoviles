package com.example.prctica3;

public class Cuota {
    private int duracion;

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int local() {
        return duracion;
    }

    public int nacional() {
        return duracion * 2;
    }

    public int internacional() {
        return duracion * 3;
    }
}
