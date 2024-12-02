package com.example.fragmentitos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class arriba extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_arriba, container, false);
        EditText editArriba = vista.findViewById(R.id.editArriba);
        Button buttonArriba = vista.findViewById(R.id.buttonArriba);

        buttonArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editAbajo = getActivity().findViewById(R.id.editAbajo);
                Toast.makeText(getContext(), editAbajo.getHint().toString(), Toast.LENGTH_SHORT).show();
                editAbajo.setText(editArriba.getText().toString());
            }
        });
        return vista;
    }
}