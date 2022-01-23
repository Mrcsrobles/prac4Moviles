package com.example.multijuego.resultados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multijuego.R;

import java.util.Objects;

public class results_games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        setContentView(R.layout.activity_results_games);
    }

    public void colores(View view) {
        Intent intent = new Intent(getBaseContext(), result_graph.class);
        intent.putExtra("JUEGO", 0);
        startActivity(intent);
    }


    public void calculo(View view) {
        Intent intent = new Intent(getBaseContext(), result_graph.class);
        intent.putExtra("JUEGO", 1);
        startActivity(intent);
    }

    public void simon(View view) {
        Intent intent = new Intent(getBaseContext(), result_graph.class);
        intent.putExtra("JUEGO", 2);
        startActivity(intent);
    }
}