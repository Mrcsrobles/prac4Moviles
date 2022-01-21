package com.example.multijuego.resultados;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.multijuego.MainActivity;
import com.example.multijuego.R;

import puntuacion.Puntuacion;
import puntuacion.PuntuacionDatabase;

public class results extends AppCompatActivity {
    private PuntuacionDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF00")));


        setContentView(R.layout.activity_results);
        setPuntuacion();
    }

    private void setPuntuacion() {
        TextView tv = findViewById(R.id.textView4);
        int puntuacion = getIntent().getIntExtra("PUNTUACION", 0);
        tv.setText("Ha consgeguido " + puntuacion + " puntos");
        almacenarPuntuacion(puntuacion);
    }

    public void puntuaciones(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    public void salir(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    private int getJuegoInt() {
        return getIntent().getIntExtra("JUEGO", 0);
    }

    private int getIntento() {
        return db.PuntuacionDao().getAll().length + 1;
    }

    private void almacenarPuntuacion(int puntuacion) {
        db = Room.databaseBuilder(getApplicationContext(),
                PuntuacionDatabase.class, "Puntuacion").allowMainThreadQueries().build();
        Puntuacion nuevaPuntuacion = new Puntuacion(getIntento(), getJuegoInt(), puntuacion);
        db.PuntuacionDao().insertarPuntuacion(nuevaPuntuacion);
    }


    public void estadisticas(View view) {
        Intent intent = new Intent(this,result_graph.class);
        intent.putExtra("PUNTUACION", getIntent().getIntExtra("PUNTUACION", 0));
        intent.putExtra("JUEGO", getIntent().getIntExtra("JUEGO", 0));
        startActivity(intent);
    }
}