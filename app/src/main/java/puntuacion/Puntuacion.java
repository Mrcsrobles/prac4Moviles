package puntuacion;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Puntuacion {
    @PrimaryKey
    public int intento;
    public int puntuación;
    public int juego;

    public Puntuacion(int intento, int juego,int puntuación) {
        this.intento = intento;
        this.juego = juego;
        this.puntuación = puntuación;
    }
}
