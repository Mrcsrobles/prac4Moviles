package com.example.multijuego.resultados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.multijuego.colores.juegoPalabrasColor;
import com.example.multijuego.Calculo.Calculo;
import com.example.multijuego.simon.juego_espejo;
import com.example.multijuego.MainActivity;
import com.example.multijuego.R;

import java.util.Objects;

import puntuacion.Puntuacion;
import puntuacion.PuntuacionDatabase;

public class results extends AppCompatActivity {
    private PuntuacionDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);



        setContentView(R.layout.activity_results);
        setPuntuacion();
    }

    private void setPuntuacion() {
        TextView tv = findViewById(R.id.textView4);
        int puntuacion = getIntent().getIntExtra("PUNTUACION", 0);
        int juego = getIntent().getIntExtra("JUEGO", 0);
        tv.setText("Ha consgeguido " + puntuacion + " puntos");
        almacenarPuntuacion(puntuacion,juego);
    }

    public void salir(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    private int getJuegoInt() {
        return getIntent().getIntExtra("JUEGO", 0);
    }

    private int getIntento(int juego) {
        return db.PuntuacionDao().getGamePoints(juego).length + 1;
    }

    private void almacenarPuntuacion(int puntuacion,int juego) {
        db = Room.databaseBuilder(getApplicationContext(),
                PuntuacionDatabase.class, "Puntuacion").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        Puntuacion nuevaPuntuacion = new Puntuacion(getIntento(juego), getJuegoInt(), puntuacion);
        db.PuntuacionDao().insertarPuntuacion(nuevaPuntuacion);
    }


    public void estadisticas(View view) {
        Intent intent = new Intent(this,result_graph.class);
        intent.putExtra("PUNTUACION", getIntent().getIntExtra("PUNTUACION", 0));
        intent.putExtra("JUEGO", getIntent().getIntExtra("JUEGO", 0));
        startActivity(intent);
    }

    public void reintentar(View view){
        int juego = getIntent().getIntExtra("JUEGO", 0);
        Intent intent=null;
        if (juego==0){
             intent= new Intent(this,juegoPalabrasColor.class);
        }else if (juego==1){
            intent= new Intent(this,Calculo.class);
        }else{
            intent= new Intent(this,juego_espejo.class);
        }

        startActivity(intent);
    }
}