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

        sqLiteDatabase.execSQL("CREATE TABLE transaccion (\n" +
                "id_transaccion INT PRIMARY KEY," +
                "titulo VARCHAR(100)," +
                "descripcion VARCHAR(100)," +
                "ingreso BOOLEAN," +
                "tipo VARCHAR(50)," +
                "monto FLOAT" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE estadisticas (" +
                "id_estadistica INT PRIMARY KEY," +
                "id_usuario VARCHAR(20)," +
                "monto FLOAT," +
                "ingresos FLOAT," +
                "gastos FLOAT," +
                "limite FLOAT," +
                "meta FLOAT," +
                "limiteDiario FLOAT," +
                "FOREIGN KEY (id_usuario) REFERENCES usuario(clave)" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE user_tracc (\n" +
                "id_user_tracc INT PRIMARY KEY," +
                "usuario VARCHAR(20)," +
                "transaccion INT," +
                "FOREIGN KEY (usuario) REFERENCES usuario(clave)," +
                "FOREIGN KEY (transaccion) REFERENCES transaccion(id_transaccion)" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
