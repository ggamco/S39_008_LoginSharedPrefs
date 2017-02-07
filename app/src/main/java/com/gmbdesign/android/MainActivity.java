package com.gmbdesign.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Práctica en la que vamos a recuperar el archivo de preferencias. dentro buscaremos si
 * existe una variable que indica si el usuario esta registrado ya o no.
 *
 * En caso de no estar registrado mostramos la actividad de login, si no la de inicio.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //cargamos el archivo de preferencias
        SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);

        //buscamos la clave de registro
        boolean esRegistrado = prefs.getBoolean("registrado", false);

        //control de vistas -> si esta registrado a inicio, sino a login
        Intent intent;

        if(esRegistrado){
            intent = new Intent(this, InicioActivity.class);
        } else {
            intent = new Intent(this, LogActivity.class);
        }

        //lanzamos la actividad utilizando el intent explicito
        this.startActivity(intent);
    }
}
