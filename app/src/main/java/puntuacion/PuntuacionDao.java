package puntuacion;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PuntuacionDao {
    @Insert
    public void insertarPuntuacion(Puntuacion... puntuaciones);

    @Query("DELETE FROM Puntuacion")
    public void deletePuntuaciones();

    @Query("SELECT * FROM Puntuacion WHERE juego = :juegoSeleccionado")
    public Puntuacion[] getGamePoints(int juegoSeleccionado);

    @Query("SELECT * FROM Puntuacion")
    public Puntuacion[] getAll();

}
