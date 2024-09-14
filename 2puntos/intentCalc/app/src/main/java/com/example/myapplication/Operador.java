package com.example.myapplication;

public class Operador {

    public String circulito (String input) {
        try {
            double area = Math.pow(Double.parseDouble(input), 2) * Math.PI;
            return "El area es de " + area + " m2";
        } catch (Exception e) {
            return "Formato invalido";
        }
    }

    public String triangulito (String base, String altura) {
        try {
            double area = (double) (Double.parseDouble(base) * Double.parseDouble(altura)) / 2;
            return "El area es de " +  area + " m2";
        } catch (Exception e) {
            return "Formato invalido";
        }
    }
}
