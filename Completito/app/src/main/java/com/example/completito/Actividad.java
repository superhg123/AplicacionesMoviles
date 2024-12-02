package com.example.completito;

import android.content.Intent;
import android.widget.ImageView;

public class Actividad {
    private String titulo;
    private String subtitulo;
    private String fecha;
    private int imagen;
    private Intent intentito;


    public Actividad(int imagen, String titulo, String subtitulo, String fecha, Intent intentito) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.fecha = fecha;
        this.intentito = intentito;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getFecha() {
        return fecha;
    }

    public int getImagen() {
        return imagen;
    }

    public Intent getIntentito() {
        return intentito;
    }
}
