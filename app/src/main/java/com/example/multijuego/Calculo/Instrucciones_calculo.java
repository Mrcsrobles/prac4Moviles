package com.example.multijuego.Calculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.multijuego.R;

public class Instrucciones_calculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones_calculo);
    }

    public void calculo(View view){
        Intent intent = new Intent(getBaseContext(), Calculo.class);
        startActivity(intent);
    }
}