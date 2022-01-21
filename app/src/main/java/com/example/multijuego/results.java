package com.example.multijuego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setPuntuacion();
    }
    private void setPuntuacion(){
        TextView tv = findViewById(R.id.textView4);
        int puntuacion =  getIntent().getIntExtra("PUNTUACION",0);
        tv.setText("Ha consgeguido "+puntuacion+ " puntos");
    }
    public void puntuaciones(View view){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    public void salir(View view){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}