package com.example.arreglos;

public class Clasesita {
    private double[] ordenar(double[] arreglo) {
        double apuntador;
        for(int x = 0; x < arreglo.length; x++) {
            for(int y = x+1; y < arreglo.length; y++) {
                if(arreglo[x] > arreglo[y]) {
                    apuntador = arreglo[x];
                    arreglo[x] = arreglo[y];
                    arreglo[y] = apuntador;
                }
            }
        }
        return arreglo;
    }

    public double menor(double[] arreglito) {
        return ordenar(arreglito)[arreglito.length-1];
    }

    public double mayor(double[] arreglito) {
        return ordenar(arreglito)[0];
    }

    public double suma(double[] arreglito) {
        double suma = 0;
        for (double x : arreglito) suma += x;
        return suma;
    }

    public double promedio(double[] arreglito) {
        return suma(arreglito)/arreglito.length;
    }
}
