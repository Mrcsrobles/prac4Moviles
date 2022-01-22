package com.example.multijuego.colores;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.multijuego.MainActivity;
import com.example.multijuego.R;

public class Instrucciones_palabras_color extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        ActionBar mActionBar = getSupportActionBar();


        setContentView(R.layout.activity_instrucciones_palabras_color);
    }
    public void colores(View view) {
        Intent intent = new Intent(this,juegoPalabrasColor.class);
        startActivity(intent);
    }
    public void salir(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}