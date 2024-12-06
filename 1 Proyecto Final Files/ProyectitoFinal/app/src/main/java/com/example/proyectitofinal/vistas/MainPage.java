package com.example.proyectitofinal.vistas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.adaptadores.TransaccionesAdapter;
import com.example.proyectitofinal.clases.Transaccion;
import com.example.proyectitofinal.modelo.Basesita;

import java.util.ArrayList;


public class MainPage extends Fragment {
    ArrayList<Transaccion> transacciones = new ArrayList<>();

    public static MainPage newInstance(String claveUsuario) {
        
        Bundle args = new Bundle();
        args.putString("Usuario", claveUsuario);
        MainPage fragment = new MainPage();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_main_page, container, false);
        String clave = getArguments().getString("Usuario");
        ListView listView = vista.findViewById(R.id.listaTransacciones);
        Basesita admin = new Basesita(getContext(), "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT transaccion FROM user_tracc WHERE usuario=" + clave, null);
        ArrayList<Integer> ids = new ArrayList<>();
        while(cursor.moveToNext()) {
            ids.add(cursor.getInt(0));
        }

        Toast.makeText(getContext(), "IDS: " + ids.toString(), Toast.LENGTH_SHORT).show();

        ids.forEach((id) -> {
            transacciones.add(Transaccion.recuperarDeBase(getContext(), id));
        });
        TransaccionesAdapter adaptador = new TransaccionesAdapter(transacciones, getContext());
        listView.setAdapter(adaptador);
        return vista;
    }
}