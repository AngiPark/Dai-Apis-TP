package com.example.tpdaiapis;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;

public class SearchFragment extends Fragment {
    Button btnBuscar;
    EditText edtText;
    ListView lvResultado;

    View rootLayout;
    public SearchFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (rootLayout == null) {
            rootLayout = inflater.inflate(R.layout.fragment_search, container, false);
        }

        ObtenerReferencias();

        SetearListeners();

        return rootLayout;

    }

    private void ObtenerReferencias() {
        btnBuscar      = (Button) rootLayout.findViewById(R.id.btnBuscar);
        edtText         = (EditText) rootLayout.findViewById(R.id.edtText);
        lvResultado   = (ListView) rootLayout.findViewById(R.id.lvResultado);
    }

    private void SetearListeners() {btnBuscar.setOnClickListener(btnBuscar_Click);}

    View.OnClickListener btnBuscar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (DatosValidos()) {

            }
        }
    };

    private boolean DatosValidos() {
        boolean blnRetorno = true;
        String strMensaje = "";

        if (ValidacionesHelpers.esUnStringValido(edtText)) {
            strMensaje += "Ingrese titulo de pelicula\n";
            blnRetorno = false;
        }
    }

    private class TareaAsincronicaSearchMovie extends AsyncTask<Void, String, String>{

    }
    }

