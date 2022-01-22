package com.example.multijuego;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.multijuego.resultados.results;

import java.util.ArrayList;

public class juego_espejo extends AppCompatActivity {
    private int pos = 0;
    private int round = 2;
    private ArrayList<Integer> sol = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_espejo);
    }

    public void generateSequence(View view) {
        Button button = findViewById(R.id.button17);
        button.setText("Siguiente");
        findViewById(R.id.button17).setEnabled(false);
        disableButtons();

        findViewById(R.id.button0a).setAlpha(0.5F);
        findViewById(R.id.button1a).setAlpha(0.5F);
        findViewById(R.id.button2a).setAlpha(0.5F);
        findViewById(R.id.button3a).setAlpha(0.5F);
        int lastButton;
        if (sol.size()==0) {
            lastButton= this.getRandomNumber(0, 3);
        }else{
            lastButton = this.getRandomNumber(0, 3);
            while (sol.get(sol.size()-1)==lastButton){
                lastButton = this.getRandomNumber(0, 3);
            }
        }
        this.sol.add(lastButton);

        int val = lastButton;
        switch (val) {
            case 0:
                button = findViewById(R.id.button0a);
                break;
            case 1:
                button = findViewById(R.id.button1a);
                break;
            case 2:
                button = findViewById(R.id.button2a);
                break;
            case 3:
                button = findViewById(R.id.button3a);
                break;
        }
        button.setAlpha(1);
        findViewById(R.id.button17).setEnabled(true);
        pos++;
        if (this.sol.size() == round+1) {
            button = findViewById(R.id.button17);
            button.setText("Te toca");
            findViewById(R.id.button17).setEnabled(false);
            enableButtons();

            this.sol.remove(this.sol.size()-1);

            findViewById(R.id.button0a).setAlpha(0.5F);
            findViewById(R.id.button1a).setAlpha(0.5F);
            findViewById(R.id.button2a).setAlpha(0.5F);
            findViewById(R.id.button3a).setAlpha(0.5F);
        }
    }

    public void b0(View view) {
        if (sol.get(0) == 0) {
            sol.remove(0);
            if (sol.size() == 0) {
                finishRound();
            }
        } else {
            salir();
        }
    }

    public void b1(View view) {
        if (sol.get(0) == 1) {
            sol.remove(0);
            if (sol.size() == 0) {
                finishRound();}
        } else {
            salir();
        }
    }

    public void b2(View view) {
        if (sol.get(0) == 2) {
            sol.remove(0);
            if (sol.size() == 0) {
                finishRound();
            }
        } else {
            salir();
        }
    }

    public void b3(View view) {
        if (sol.get(0) == 3) {
            sol.remove(0);
            if (sol.size() == 0) {
                finishRound();
            }
        } else {
            salir();
        }
    }

    private void salir() {
        int puntuacion = this.round - 2;
        Intent intent = new Intent(getBaseContext(), results.class);
        intent.putExtra("PUNTUACION", puntuacion);
        intent.putExtra("JUEGO", 2);
        startActivity(intent);
    }

    private void enableButtons() {
        findViewById(R.id.button0b).setEnabled(true);
        findViewById(R.id.button1b).setEnabled(true);
        findViewById(R.id.button2b).setEnabled(true);
        findViewById(R.id.button3b).setEnabled(true);


        findViewById(R.id.button0b).setAlpha(0.7F);
        findViewById(R.id.button1b).setAlpha(0.7F);
        findViewById(R.id.button2b).setAlpha(0.7F);
        findViewById(R.id.button3b).setAlpha(0.7F);
    }

    private void disableButtons() {
        findViewById(R.id.button0b).setEnabled(false);
        findViewById(R.id.button1b).setEnabled(false);
        findViewById(R.id.button2b).setEnabled(false);
        findViewById(R.id.button3b).setEnabled(false);

        findViewById(R.id.button0b).setAlpha(0.3F);
        findViewById(R.id.button1b).setAlpha(0.3F);
        findViewById(R.id.button2b).setAlpha(0.3F);
        findViewById(R.id.button3b).setAlpha(0.3F);
    }

    private void finishRound(){
        this.round++;
        Button button = findViewById(R.id.button17);
        button.setEnabled(true);
        button.setText("Empezar");

        this.sol = new ArrayList();
        this.pos=0;
        disableButtons();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}