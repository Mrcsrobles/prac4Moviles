package com.example.multijuego.Calculo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multijuego.R;
import com.example.multijuego.resultados.results;

import java.util.Objects;

public class Calculo extends AppCompatActivity {
    int contador = 1;
    int sol = 0;
    int correctas = 0;
    int errores = 0;

    private MediaPlayer correcto ;
    private MediaPlayer incorrecto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        correcto = MediaPlayer.create(Calculo.this, R.raw.correct);
        incorrecto = MediaPlayer.create(Calculo.this, R.raw.incorrect);

        setContentView(R.layout.activity_calculo);
        ponerPregunta();
    }

    public void ponerPregunta() {
        contador++;
        TextView textView = findViewById(R.id.textView5);
        int primerNum = getRandomNumber(1, contador);
        int segunNum = getRandomNumber(1, contador);
        int operador = getRandomNumber(0, 3);//0+1-2*
        if (operador == 0) {
            sol = primerNum + segunNum;
            textView.setText(primerNum + "+" + segunNum);
        } else if (operador == 1) {

            sol = Math.max(primerNum, segunNum) - Math.min(primerNum, segunNum);
            textView.setText(Math.max(primerNum, segunNum) + "-" + Math.min(primerNum, segunNum));
        } else {
            sol = primerNum * segunNum;
            textView.setText(primerNum + "*" + segunNum);
        }
    }

    public void comprobar(View view) {
        EditText num = findViewById(R.id.editTextNumber);
        if (Integer.parseInt(num.getText().toString()) == sol) {
            this.correctas++;
            correcto.start();
            num.setText("");
            this.ponerPregunta();
        } else {
            errores++;
            incorrecto.start();

            Toast.makeText(getApplicationContext(), "Error nº" + errores, Toast.LENGTH_SHORT).show();
            if (errores == 3) {
                int puntuacion = this.correctas;
                Intent intent = new Intent(getBaseContext(), results.class);
                intent.putExtra("PUNTUACION", puntuacion);
                intent.putExtra("JUEGO", 1);
                startActivity(intent);
            }

        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}