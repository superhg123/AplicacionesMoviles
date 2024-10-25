package com.example.murisioncita;

import java.util.ArrayList;
import java.util.Random;

public class Clasesita {
    private static String[] sustantivos = {
            "casa", "mesa", "perro", "gato", "coche", "libro", "nino", "nina", "dia", "mano",
            "tiempo", "agua", "comida", "persona", "amigo", "mujer", "hombre", "trabajo",
            "escuela", "ciudad", "familia", "juego", "silla", "cama", "television", "telefono",
            "zapato", "pajaro", "flor", "arbol", "ventana", "puerta", "cuchara", "tenedor",
            "plato", "bicicleta", "pelota", "animal", "maestra", "profesor", "estudiante",
            "computadora", "internet", "jardin", "mercado", "cielo", "estrella", "luna",
            "sol", "nube", "rio", "mar", "playa", "montana", "carro", "autobus", "camion",
            "tren", "aeropuerto", "billete", "vacaciones", "fruta", "verdura", "carne",
            "pan", "leche", "huevo", "chocolate", "dulce", "pastel", "cumpleanos", "fiesta",
            "regalo", "celebracion", "cancion", "musica", "pelicula", "serie", "teatro",
            "libertad", "justicia", "paz", "amor", "amistad", "sueño", "esperanza",
            "vida", "muerte", "historia", "cultura", "idioma", "arte", "deporte", "viaje",
            "aula", "tarea", "examen", "vacaciones", "esternocleidomastoideo"
    };

    private Random random = new Random();
    private String palabra = sustantivos[random.nextInt(100)];
    private int intentos;
    private String resultado = iniciarResultado();

    public String getResultado() {
        return resultado;
    }

    public String getPalabra() {
        return palabra;
    }

    public int getIntentos() {
        return intentos;
    }

    private String iniciarResultado() {
        String retorno = "";
        for(int x = 0; x < palabra.length(); x++) {
            retorno+="_ ";
        }
        return retorno;
    }

    public String verificar(String car) {
        if(palabra.contains(car) && !resultado.contains(car)) {
            ArrayList<Integer> posiciones = new ArrayList<>();
            for(int x = 0; x < palabra.length(); x++) {
                if(palabra.charAt(x) == car.charAt(0))
                    posiciones.add(x);
            }
            char[] arreglito = resultado.toCharArray();
            for(int x : posiciones) {
                arreglito[x*2] = car.charAt(0);
            }
            resultado = String.valueOf(arreglito);
        } else {
            intentos++;
        }
        return resultado;
    }

    public int verificarImagen() {
        if(intentos == 0)
            return 0;
        if (intentos == 1)
            return R.drawable.oneerror;
        if (intentos == 2)
            return R.drawable.twoerrores;
        if (intentos == 3)
            return R.drawable.harbolerrores;
        if (intentos == 4)
            return R.drawable.fourerrores;
        if (intentos == 5)
            return R.drawable.faiverrores;
        if (intentos == 6)
            return R.drawable.ded;
        return R.drawable.ded;
    }
}
