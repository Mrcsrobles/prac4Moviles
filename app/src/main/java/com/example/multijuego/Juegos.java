package com.example.multijuego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multijuego.Calculo.Instrucciones_calculo;
import com.example.multijuego.colores.Instrucciones_palabras_color;
import com.example.multijuego.simon.instrucciones_simon_espejo;

import java.util.Objects;

public class Juegos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
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