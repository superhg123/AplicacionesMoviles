package com.example.combobox;

public class Operador {
    private int datito1;
    private int datito2;

    public Operador(int datito1, int datito2) {
        this.datito1 = datito1;
        this.datito2 = datito2;
    }

    public Operador(int datito1) {
        this.datito1 = datito1;
    }

    public double cuadrado() {
        return Math.pow(datito1,2);
    }

    public double rectangulo() {
        return (datito1 * datito2);
    }

    public double triangulo() {
        return ((double) (datito1 * datito2) /2);
    }
}
