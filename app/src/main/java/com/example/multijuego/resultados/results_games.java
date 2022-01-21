package com.example.multijuego.resultados;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.multijuego.R;

public class results_games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF00")));


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
}