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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.adaptadores.OpcionesAdapter;
import com.example.proyectitofinal.clases.Opcion;
import com.example.proyectitofinal.clases.Transaccion;
import com.example.proyectitofinal.modelo.Basesita;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

import java.util.ArrayList;

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

        categoria.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ArrayList<Opcion> opciones = new ArrayList<>();
                if(radioGroup.getCheckedRadioButtonId() == R.id.tipoGasto) {

                    opciones.add(new Opcion("Vivienda", R.drawable.vivienda_icon));
                    opciones.add(new Opcion("Comida", R.drawable.comida_icon));
                    opciones.add(new Opcion("Transporte", R.drawable.transporte_icon));
                    opciones.add(new Opcion("Salud", R.drawable.salud_icon));
                    opciones.add(new Opcion("Entretenimiento", R.drawable.entretenimiento_icon));
                    opciones.add(new Opcion("Ropa y accesorios", R.drawable.ropa_icon));
                    opciones.add(new Opcion("Deuda", R.drawable.deuda_icon));
                    opciones.add(new Opcion("Educacion", R.drawable.educacion_icon));
                    opciones.add(new Opcion("Oscio", R.drawable.oscio_icon));


                } else if (radioGroup.getCheckedRadioButtonId() == R.id.tipoIngreso) {

                    opciones.add(new Opcion("Salario", R.drawable.money));
                    opciones.add(new Opcion("Beca", R.drawable.beca_icon));
                    opciones.add(new Opcion("Ingreso pasivo", R.drawable.pasivo_icon));
                    opciones.add(new Opcion("Ganancias", R.drawable.ganancia_icon));
                    opciones.add(new Opcion("Subsidio", R.drawable.subsidio_icon));
                    opciones.add(new Opcion("Regalo", R.drawable.regalo_icon));
                    opciones.add(new Opcion("Premio", R.drawable.premio_icon));
                    opciones.add(new Opcion("Venta", R.drawable.venta_icon));

                }

                opciones.add(new Opcion("Otros", R.drawable.otros_icon));

                ArrayList<String> strings = new ArrayList<>();
                for(Opcion x : opciones) {
                    strings.add(x.getValor());
                }

                opciones.add(new Opcion("Otros", R.drawable.otros_icon));
                OpcionesAdapter adaptador = new OpcionesAdapter(getContext(), R.layout.opciones_adapter, opciones, strings);
                spinner.setAdapter(adaptador);
            }
        });


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
                    db.close();

                    Basesita admin2 = new Basesita(getContext(), "admin", null, 1);
                    SQLiteDatabase lecturaStats = admin2.getReadableDatabase();
                    Cursor cursor = lecturaStats.rawQuery("SELECT * FROM estadisticas WHERE id_usuario=" + claveUsuario, null);
                    if(cursor.moveToFirst()) {
                        ContentValues valoresStats = new ContentValues();
                        float balance = cursor.getFloat(2);

                        float montoTrac = Float.parseFloat(monto.getText().toString());
                        if(categoria.getCheckedRadioButtonId() == R.id.tipoIngreso) {
                            float ganancias = cursor.getFloat(3);
                            ganancias += montoTrac;
                            balance += montoTrac;
                            valoresStats.put("ingresos", ganancias);
                        } else if (categoria.getCheckedRadioButtonId() == R.id.tipoGasto) {
                            float gastos = cursor.getFloat(4);
                            gastos += montoTrac;
                            balance-= montoTrac;
                            valoresStats.put("gastos", gastos);
                        }

                        valoresStats.put("monto", balance);
                        SQLiteDatabase escrituraStats = admin2.getWritableDatabase();
                        escrituraStats.update("estadisticas", valoresStats, "id_usuario=?", new String[]{claveUsuario});
                    }
                }
            }
        });
        return vista;
    }
}