package com.example.proyectitofinal.vistas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.adaptadores.TransaccionesAdapter;
import com.example.proyectitofinal.clases.Transaccion;
import com.example.proyectitofinal.listener.DataChangedListener;
import com.example.proyectitofinal.modelo.Basesita;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainPage extends Fragment {
    ArrayList<Transaccion> transacciones = new ArrayList<>();
    private ListView lista;

    public static MainPage newInstance(String claveUsuario) {

        Bundle args = new Bundle();
        args.putString("Usuario", claveUsuario);
        MainPage fragment = new MainPage();
        fragment.setArguments(args);
        return fragment;
    }

    private void recargarLista(String clave) {
        Basesita admin = new Basesita(getContext(), "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT transaccion FROM user_tracc WHERE usuario=" + clave, null);
        ArrayList<Integer> ids = new ArrayList<>();
        while(cursor.moveToNext()) {
            ids.add(cursor.getInt(0));
        }
        ids.forEach((id) -> {
            transacciones.add(Transaccion.recuperarDeBase(getContext(), id));
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_main_page, container, false);
        String clave = getArguments().getString("Usuario");


        lista = vista.findViewById(R.id.listaTransacciones);

        Basesita admin2 = new Basesita(getContext(), "admin", null, 1);

        SQLiteDatabase stats = admin2.getReadableDatabase();
        Cursor cursorStats = stats.rawQuery("SELECT * FROM estadisticas WHERE id_usuario=?", new String[]{clave});

        if(cursorStats.moveToFirst()) {
            float monto = cursorStats.getFloat(2);
            float ingresos = cursorStats.getFloat(3);
            float gastos = cursorStats.getFloat(4);
            float meta = cursorStats.getFloat(6);
            TextView balanceDisplay = vista.findViewById(R.id.balanceDisplay);
            TextView ingresosDisplay = vista.findViewById(R.id.ingresosDisplay);
            TextView gastosDisplay = vista.findViewById(R.id.gastosDisplay);
            TextView metaMainDisplay = vista.findViewById(R.id.metaMainDisplay);
            balanceDisplay.setText(String.format("$ %s", monto));
            ingresosDisplay.setText(String.format("$ %s", ingresos));
            gastosDisplay.setText(String.format("$ %s", gastos));
            metaMainDisplay.setText(String.format("De $%s de meta", meta));


        } else {
            Toast.makeText(getContext(), "No se encontraron los datos financieros", Toast.LENGTH_SHORT).show();
        }


        recargarLista(clave);


        TransaccionesAdapter adaptador = new TransaccionesAdapter(transacciones, getContext());
        adaptador.setDataChangedListener(new DataChangedListener() {
            @Override
            public void onDataChanged(ArrayList<Transaccion> transacciones) {
                Toast.makeText(getContext(), "Transaccion Eliminada", Toast.LENGTH_SHORT).show();
                adaptador.notifyDataSetChanged();
            }
        });
        lista.setAdapter(adaptador);

        return vista;
    }
}