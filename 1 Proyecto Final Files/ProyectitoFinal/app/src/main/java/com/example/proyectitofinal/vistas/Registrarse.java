package com.example.proyectitofinal.vistas;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.adaptadores.SpinnerAdapter;
import com.example.proyectitofinal.modelo.Basesita;

public class Registrarse extends Fragment {


    public Registrarse() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_registrarse, container, false);
        String[] delgaciones = {"Cuauhtémoc", "Miguel Hidalgo"};
        String[] colonias = {"Obrera", "Popotla"};
        Spinner spinnerDel = vista.findViewById(R.id.delegaciones);
        Spinner spinnerCol = vista.findViewById(R.id.colonias);

        spinnerDel.setAdapter(new SpinnerAdapter(delgaciones, getContext()));
        spinnerCol.setAdapter(new SpinnerAdapter(colonias, getContext()));

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                findNavController(Registrarse.this).navigate(R.id.backToMainLogin2);
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        Button boton = vista.findViewById(R.id.registrarse);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                String clave = ((EditText)vista.findViewById(R.id.clave)).getText().toString();
                String nombre = ((EditText)vista.findViewById(R.id.nombre)).getText().toString();
                String edad = ((EditText)vista.findViewById(R.id.edad)).getText().toString();
                String delegacion = ((Spinner)vista.findViewById(R.id.delegaciones)).getSelectedItem().toString();
                String colonia = ((Spinner)vista.findViewById(R.id.colonias)).getSelectedItem().toString();
                RadioButton seleccionado = vista.findViewById(((RadioGroup)vista.findViewById(R.id.sexo)).getCheckedRadioButtonId());
                String sexo = seleccionado.getText().toString();
                boolean ingles = ((CheckBox)vista.findViewById(R.id.ingles)).isChecked();
                boolean frances = ((CheckBox)vista.findViewById(R.id.frances)).isChecked();
                Basesita admin = new Basesita(getContext(), "admin", null, 1);
                SQLiteDatabase sicuel = admin.getWritableDatabase();
                ContentValues contenido = new ContentValues();
                contenido.put("clave", clave);
                contenido.put("nombre", nombre);
                contenido.put("edad", edad);
                contenido.put("sexo", sexo);
                contenido.put("delegacion", delegacion);
                contenido.put("colonia", colonia);
                contenido.put("ingles", ingles);
                contenido.put("frances", frances);

                    sicuel.insert("usuario", null, contenido);
                    sicuel.close();
                    findNavController(Registrarse.this).navigate(R.id.action_registroFinalizado);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return vista;
    }


}