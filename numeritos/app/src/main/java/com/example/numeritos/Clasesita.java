package com.example.numeritos;

public class Clasesita {
    private static String[] unidades = {"", "uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve", "diez"};
    private static String[] dieces = {"diez", "once","doce","trece","catorce","quince","dieciseis","diesisiete","dieciocho","diecinueve","veinte"};
    private static String[] decenas = {"","diez", "veinti", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
    private static String[] centenas = {"", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};

    public static String unidades(int numero) {
        return unidades[numero];
    }

    public static String decenas(int numero) {
        if (numero < 10)
            return unidades(numero);
        if(numero < 20)
            return dieces[numero-10];
        if (numero == 10)
            return "diez";
        if (numero == 20)
            return "veinte";
        int i = Integer.parseInt(("" + numero).substring(0, 1));
        if (numero < 30)
            return decenas[i] + unidades(Integer.parseInt(("" + numero).substring(1)));
        return decenas[i] + ((numero - (numero/10)*10 == 0) ? "" : " y ") + unidades(Integer.parseInt(("" + numero).substring(1)));
    }

    public static String centenas(int numero) {
        if (numero < 100)
            return decenas(numero);
        if(numero == 100)
            return "cien";
        if(Integer.parseInt(("" + numero).substring(1)) > 9)
            return centenas[Integer.parseInt(("" + numero).substring(0,1))] + ' ' + decenas(Integer.parseInt(("" + numero).substring(1)));
        return centenas[Integer.parseInt(("" + numero).substring(0,1))] + ' ' + unidades(Integer.parseInt(("" + numero).substring(2)));
    }

    public static String millas(int numero) {
        if (("" + numero).length() == 6)
            return centenas(Integer.parseInt(("" +  numero).substring(0,3))) + "mil " + centenas(Integer.parseInt(("" + numero).substring(3,6)));
        if (("" + numero).length() == 5)
            return decenas(Integer.parseInt(("" +  numero).substring(0,2))) + " mil " + centenas(Integer.parseInt(("" + numero).substring(2,5)));
        return unidades(Integer.parseInt(("" +  numero).substring(0,1))) + " mil " + centenas(Integer.parseInt(("" + numero).substring(1,4)));
    }
}
