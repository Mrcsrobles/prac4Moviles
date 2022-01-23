package puntuacion;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PuntuacionDao {
    @Insert
    void insertarPuntuacion(Puntuacion... puntuaciones);

    @Query("DELETE FROM Puntuacion")
    void deletePuntuaciones();

    @Query("SELECT * FROM Puntuacion WHERE juego = :juegoSeleccionado")
    Puntuacion[] getGamePoints(int juegoSeleccionado);

    @Query("SELECT * FROM Puntuacion")
    Puntuacion[] getAll();

}
