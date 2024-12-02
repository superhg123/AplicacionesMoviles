package com.example.proyectitofinal.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Basesita extends SQLiteOpenHelper {

    public Basesita(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE usuario(" +
                "clave VARCHAR(20)," +
                "nombre VARCHAR(30)," +
                "edad INT," +
                "sexo VARCHAR(10)," +
                "delegacion VARCHAR(100)," +
                "colonia VARCHAR(100)," +
                "ingles BOOLEAN," +
                "frances BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
