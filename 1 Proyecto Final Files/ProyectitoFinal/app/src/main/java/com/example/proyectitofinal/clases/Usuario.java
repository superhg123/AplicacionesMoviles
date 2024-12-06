package com.example.proyectitofinal.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectitofinal.modelo.Basesita;

public class Usuario {
    private String clave;
    private String nombre;
    private int edad;
    private String sexo;
    private String delegacion;
    private String colonia;
    private boolean ingles;
    private boolean frances;

    public Usuario(String clave, String nombre, int edad, String sexo, String delegacion, String colonia, boolean ingles, boolean frances) {
        this.clave = clave;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.delegacion = delegacion;
        this.colonia = colonia;
        this.ingles = ingles;
        this.frances = frances;
    }

    public void insertarEnBase(Context contexto) {
        Basesita admin = new Basesita(contexto, "admin", null, 1);
        SQLiteDatabase sicuel = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("clave", clave);
        valores.put("nombre", nombre);
        valores.put("edad", edad);
        valores.put("sexo", sexo);
        valores.put("delegacion", delegacion);
        valores.put("colonia", colonia);
        valores.put("ingles", ingles);
        valores.put("frances", frances);
        sicuel.insert("usuario", null, valores);
    }

    public static Usuario recuperarDeBase(Context contexto, String id) {
        Basesita admin = new Basesita(contexto, "admin", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE clave = " + id, null);
        if(cursor.moveToFirst()) {
            return new Usuario(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    (cursor.getInt(6) == 1),
                    (cursor.getInt(7) == 1)
            );
        } else {
            return null;
        }
    }


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public boolean isIngles() {
        return ingles;
    }

    public void setIngles(boolean ingles) {
        this.ingles = ingles;
    }

    public boolean isFrances() {
        return frances;
    }

    public void setFrances(boolean frances) {
        this.frances = frances;
    }
}
