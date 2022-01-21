package com.example.multijuego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import puntuacion.Puntuacion;
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
}