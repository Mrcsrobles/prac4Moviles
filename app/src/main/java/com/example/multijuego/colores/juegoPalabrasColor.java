package com.example.multijuego.colores;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multijuego.R;
import com.example.multijuego.resultados.results;

import java.util.Objects;

public class juegoPalabrasColor extends AppCompatActivity {
    int contador = 0;
    String[] colores = {"Rojo", "Azul", "Verde", "Rosa", "Negro"};
    String[] hexColores = {"#ff0000", "#0001fe", "#00fe00", "#ff5eef", "#000000"};

    int correctas = 0;
    int puntuacion = 0;
    Boolean sol;
    private MediaPlayer correcto ;
    private MediaPlayer incorrecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        correcto = MediaPlayer.create(juegoPalabrasColor.this, R.raw.correct);
        incorrecto = MediaPlayer.create(juegoPalabrasColor.this, R.raw.incorrect);

        setContentView(R.layout.activity_juego_palabras_color);
        cambiarColores();
    }

    public void cambiarColores() {
        contador++;
        if (contador < 30) {
            TextView textView = findViewById(R.id.textView3);
            int pos = getRandomNumber(0, this.colores.length);
            textView.setText(this.colores[pos]);
            int hexpos = getRandomNumber(0, this.hexColores.length);
            textView.setTextColor(Color.parseColor(this.hexColores[hexpos]));
            this.sol = pos == hexpos;
        } else {
            puntuacion = this.calcularPuntuacion();
            Intent intent = new Intent(getBaseContext(), results.class);
            intent.putExtra("PUNTUACION", this.puntuacion);
            intent.putExtra("JUEGO", 0);

            startActivity(intent);
        }
    }

    private int calcularPuntuacion() {
        return this.correctas;
    }

    public void iguales(View view) {
        if (this.sol) {
            this.correctas++;
            correcto.start();
        } else {
            incorrecto.start();
        }
        this.cambiarColores();
    }

    public void distintas(View view) {
        if (!this.sol) {
            this.correctas++;
            correcto.start();
        } else {
            incorrecto.start();
        }
        this.cambiarColores();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}