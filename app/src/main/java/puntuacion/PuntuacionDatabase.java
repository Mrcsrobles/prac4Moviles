package puntuacion;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1,entities ={Puntuacion.class})
public abstract class PuntuacionDatabase extends RoomDatabase {
    abstract public PuntuacionDao PuntuacionDao();
}
