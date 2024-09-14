package com.example.intent2;

public class Operador {
    private int valor1;
    private int valor2;

    public Operador(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public Operador(int valor1) {
        this.valor1 = valor1;
    }

    public int cuadrado() {
        return valor1*valor1;
    }

    public int rectangulo() {
        return valor1*valor2;
    }
}
