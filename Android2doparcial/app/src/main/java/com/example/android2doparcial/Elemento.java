package com.example.android2doparcial;

public class Elemento {
    private String titulo;
    private String subtitulo;
    private String contenido;
    private String color;

    public Elemento(String titulo, String subtitulo, String contenido, String color) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.color = color;
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getColor() {
        return color;
    }
}
