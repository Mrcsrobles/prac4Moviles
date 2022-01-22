package com.example.multijuego.Calculo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.multijuego.MainActivity;
import com.example.multijuego.R;

public class Instrucciones_calculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        ActionBar mActionBar = getSupportActionBar();


        setContentView(R.layout.activity_instrucciones_calculo);
    }

    public void calculo(View view){
        Intent intent = new Intent(getBaseContext(), Calculo.class);
        startActivity(intent);
    }
    public void salir(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}