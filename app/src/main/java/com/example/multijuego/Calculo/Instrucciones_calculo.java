package com.example.multijuego.Calculo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multijuego.MainActivity;
import com.example.multijuego.R;

import java.util.Objects;

public class Instrucciones_calculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


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