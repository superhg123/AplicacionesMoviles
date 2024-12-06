package com.example.proyectitofinal.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.proyectitofinal.modelo.Basesita;

public class Transaccion {
    private int id;
    private String titulo;
    private String descripcion;
    private Boolean ingreso;
    private String tipo;
    private Float monto;

    public Transaccion(String titulo, String descripcion, Boolean ingreso, String tipo, Float monto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ingreso = ingreso;
        this.tipo = tipo;
        this.monto = monto;
    }

    public Transaccion(int id, String titulo, String descripcion, Boolean ingreso, String tipo, Float monto) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ingreso = ingreso;
        this.tipo = tipo;
        this.monto = monto;
    }

    public Long guardarEnBase(Context context) {
        Basesita admin = new Basesita(context, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues contenido = new ContentValues();
        contenido.put("titulo", this.titulo);
        contenido.put("descripcion", this.descripcion);
        contenido.put("ingreso", this.ingreso);
        contenido.put("tipo", this.tipo);
        contenido.put("monto", this.monto);
        Toast.makeText(context, contenido.toString(), Toast.LENGTH_SHORT).show();
        db.insert("transaccion", null, contenido);
        Cursor idCursor = db.rawQuery("SELECT max(id_transaccion) FROM transaccion", null);
        idCursor.moveToFirst();
        return idCursor.getLong(0);
    }

    public static Transaccion recuperarDeBase(Context contexto, int id) {
        Basesita admin = new Basesita(contexto, "admin", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM transaccion WHERE id_transaccion=" + id, null);
        if(cursor.moveToFirst()) {
            return new Transaccion(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    (cursor.getInt(3) == 1),
                    cursor.getString(4),
                    cursor.getFloat(5)
            );
        } else return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getIngreso() {
        return ingreso;
    }

    public void setIngreso(Boolean ingreso) {
        this.ingreso = ingreso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }
}
