package com.gmbdesign.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);


    }

    /**
     * metodo que lanzará la vista de inicio y seteará en el SharedPreferences la variable
     * registrado = true, de esta manera no vuelve a visualizarse esta actividad
     * salvo que se elimine el archivo de preferencias
     */
    public void gotoInicio(View view){
        //recuperamos el xml y almacenamos la variable registrado.
        SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("registrado", true);
        editor.commit();

        //lanzamos la actividad
        Intent intent = new Intent(this, InicioActivity.class);
        this.startActivity(intent);
    }
}
