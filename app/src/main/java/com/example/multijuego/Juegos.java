package com.example.multijuego;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.multijuego.Calculo.Instrucciones_calculo;
import com.example.multijuego.colores.Instrucciones_palabras_color;

public class Juegos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        setContentView(R.layout.activity_juegos);
    }
    public void colores(View view) {
        Intent intent = new Intent(this, Instrucciones_palabras_color.class);
        startActivity(intent);
    }
    public void calculo(View view) {
        Intent intent = new Intent(this, Instrucciones_calculo.class);
        startActivity(intent);
    }
    public void espejo(View view) {
        Intent intent = new Intent(this, instrucciones_simon_espejo.class);
        startActivity(intent);
    }
}