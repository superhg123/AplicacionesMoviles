package com.example.proyectitofinal.vistas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.clases.Transaccion;
import com.example.proyectitofinal.modelo.Basesita;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

public class RegistroTransaccion extends Fragment {

    public static RegistroTransaccion newInstance(String clave) {

        Bundle args = new Bundle();
        args.putString("Usuario", clave);
        RegistroTransaccion fragment = new RegistroTransaccion();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_registro_transaccion, container, false);
        EditText titulo = vista.findViewById(R.id.tituloRegistro);
        EditText desc = vista.findViewById(R.id.descripcionRegistro);
        RadioGroup categoria = vista.findViewById(R.id.tipoTransaccion);
        AutoCompleteTextView spinner = vista.findViewById(R.id.spinnerTipo);
        EditText monto = vista.findViewById(R.id.montoRegistro);
        Button mandarRegistro = vista.findViewById(R.id.registrarTransaccion);

        String claveUsuario = getArguments().getString("Usuario");

        String[] opciones = {"Comida", "Trabajo", "Transporte"};
        ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner.setAdapter(adaptador);

        mandarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean categoriaEx = null;
                if(categoria.getCheckedRadioButtonId() == R.id.tipoIngreso) {
                    categoriaEx = true;
                } else if(categoria.getCheckedRadioButtonId() == R.id.tipoGasto) {
                    categoriaEx = false;
                }

                if(categoriaEx == null) {
                    Toast.makeText(getContext(), "No se han ingresado bien los datos", Toast.LENGTH_SHORT).show();
                } else {
                    String item = spinner.getText().toString();
                    Transaccion tracc = new Transaccion(
                        titulo.getText().toString(),
                        desc.getText().toString(),
                        categoriaEx,
                            item,
                        Float.parseFloat(monto.getText().toString())
                    );
                    tracc.guardarEnBase(getContext());
                    Long id = tracc.guardarEnBase(getContext());
                    Basesita admin = new Basesita(getContext(), "admin", null, 1);
                    SQLiteDatabase db = admin.getWritableDatabase();
                    ContentValues valores = new ContentValues();
                    valores.put("usuario", claveUsuario);
                    valores.put("transaccion", id);
                    db.insert("user_tracc", null, valores);
                    SQLiteDatabase lecturaStats = admin.getReadableDatabase();
                    Cursor cursor = lecturaStats.rawQuery("SELECT * FROM estadisticas WHERE id_usuario=" + claveUsuario, null);
                    if(cursor.moveToFirst()) {
                        ContentValues valoresStats = new ContentValues();
                        float balance = cursor.getFloat(2);

                        if(categoria.getCheckedRadioButtonId() == R.id.tipoIngreso) {
                            float ganancias = cursor.getFloat(3);
                            balance += ganancias;
                            valoresStats.put("ingresos", ganancias);
                        } else if (categoria.getCheckedRadioButtonId() == R.id.tipoGasto) {
                            float gastos = cursor.getFloat(4);
                            balance-= gastos;
                            valoresStats.put("gastos", gastos);
                        }

                        valoresStats.put("monto", balance);

                        db.update("estadisticas", valoresStats, "idUsuario=?", new String[]{claveUsuario});
                    }
                }
            }
        });
        return vista;
    }
}