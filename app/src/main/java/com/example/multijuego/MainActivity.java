package com.example.multijuego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void juegos(View view) {
        Intent intent = new Intent(this,Juegos.class);
        startActivity(intent);
    }

//Call this method on button click
}