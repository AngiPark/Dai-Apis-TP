package com.example.tpdaiapis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("APIS y OMBD Open Movie DataBase");

        ObtenerReferencias();

        SetearListeners();

        CargarDatos();
    }

    private void ObtenerReferencias(){
        lvDatos = (ListView) findViewById(R.id.lvDatos);
    }

    private void SetearListeners(){
        lvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //recibe la posicion de un id
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strMensaje;
                String strDato;

                strDato = (String) lvDatos.getItemAtPosition(position);
                strMensaje = "Click en '" + strDato + "', posicion: " + String.valueOf(position);

                Toast.makeText(getApplicationContext(), strMensaje, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void CargarDatos(){
        ArrayList<String>  datosArrayList;
        ArrayAdapter<String>  adapter;

        datosArrayList = ObtenerDatos();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosArrayList);
        lvDatos.setAdapter(adapter);
        //Cree un arrayAdapter y Infle las listas y le mande que tipo de datos hay ahi adentro(String)
    }

    private ArrayList<String> ObtenerDatos(){
        ArrayList<String> returnArrayList = new ArrayList<>();
        String strTemp;

        for(int i = 0; i<11; i++){
            strTemp = "Casillero Numero " + String.valueOf(i+100);
            returnArrayList.add(strTemp);
        }
        return returnArrayList;
    }
}