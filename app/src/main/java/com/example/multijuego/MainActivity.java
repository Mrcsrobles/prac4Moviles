package com.example.multijuego;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.multijuego.resultados.results_games;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF00")));
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