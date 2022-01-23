package puntuacion;

import androidx.room.Entity;

@Entity(primaryKeys = {"intento", "puntuación"})
public class Puntuacion {
    public int intento;
    public int puntuación;
    public int juego;

    public Puntuacion(int intento, int juego,int puntuación) {
        this.intento = intento;
        this.juego = juego;
        this.puntuación = puntuación;
    }
}
