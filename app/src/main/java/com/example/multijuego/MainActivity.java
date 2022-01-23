package com.example.multijuego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multijuego.resultados.results_games;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        setContentView(R.layout.activity_main);

    }
    public void juegos(View view) {
        Intent intent = new Intent(this,Juegos.class);
        startActivity(intent);
    }

    public void ajustes(View view) {
        Intent intent = new Intent(this,Ajustes.class);
        startActivity(intent);
    }
    public void estadisticas(View view) {
        Intent intent = new Intent(this, results_games.class);
        startActivity(intent);
    }

//Call this method on button click
}