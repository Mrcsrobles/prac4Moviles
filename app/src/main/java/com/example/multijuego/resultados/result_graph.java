package com.example.multijuego.resultados;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.multijuego.MainActivity;
import com.example.multijuego.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import puntuacion.Puntuacion;
import puntuacion.PuntuacionDatabase;

public class result_graph extends AppCompatActivity {
    GraphView graphView;
    PuntuacionDatabase db;
    int juego=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_graph);
        //Obtenemos la ActionBar instalada por AppCompatActivity
        ActionBar actionBar = getSupportActionBar();
        //Establecemos el icono en la ActionBar
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        // Activar flecha ir atrás (ir a la Parent Activity declarada en el manifest)
        actionBar.setDisplayHomeAsUpEnabled(true);

        graphView = findViewById(R.id.idGraphView);

        juego = getIntent().getIntExtra("JUEGO", 0);
        DataPoint[] dp = getDatos();
        if (dp.length == 0) {
            graphView.setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.textView).setVisibility(View.INVISIBLE);
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

        // on below line we are setting text color to our graph view.
        graphView.setTitleColor(R.color.purple_200);

        // on below line we are setting our title text size.
        graphView.setTitleTextSize(18);

        graphView.setBackgroundColor(0);
        // on below line we are adding data series to our graph view.
        graphView.addSeries(series);
    }

    private DataPoint[] getDatos() {
        db = Room.databaseBuilder(getApplicationContext(),
                PuntuacionDatabase.class, "Puntuacion").allowMainThreadQueries().build();

        int lon = db.PuntuacionDao().getGamePoints(juego).length;
        DataPoint[] lista = new DataPoint[lon];

        int i = 0;
        for (Puntuacion punt : db.PuntuacionDao().getGamePoints(juego)) {
            lista[i++] = new DataPoint(punt.intento, punt.puntuación);
        }
        return lista;
    }

    public void salir(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

}