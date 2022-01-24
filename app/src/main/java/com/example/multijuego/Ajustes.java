package com.example.multijuego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import puntuacion.PuntuacionDatabase;

public class Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
    }

    public void deleteData(View view){
        PuntuacionDatabase db = Room.databaseBuilder(getApplicationContext(),
                PuntuacionDatabase.class, "Puntuacion").allowMainThreadQueries().build();
        db.PuntuacionDao().deletePuntuaciones();
    }
    public void volver(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}