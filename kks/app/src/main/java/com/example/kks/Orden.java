package com.example.kks;

import java.util.ArrayList;

public class Orden {
    ArrayList<Keka> kekas = new ArrayList<>();

    public void agregarKeka(Keka keka) {
        this.kekas.add(keka);
    }

    public ArrayList regresarOrden() {
        return this.kekas;
    }

    public void nuevaOrden() {
        this.kekas = new ArrayList<>();
    }
}
