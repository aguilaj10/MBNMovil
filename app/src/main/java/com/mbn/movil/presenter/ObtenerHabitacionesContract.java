package com.mbn.movil.presenter;

import com.mbn.movil.model.dto.HabitacionDTO;
import com.mbn.movil.model.entities.Habitacion;

/**
 * Created by lenovo on 12/07/2017.
 */

public interface ObtenerHabitacionesContract {
    interface Vista {
        void mostrarPantallaHabitaciones();
        void mostrarError();
    }

    interface Presenter {
        void ObtenerHabitaiones();


        //Callbacks
        void exitoObtenerHabitaiones(HabitacionDTO dto);
        void errorObtenerHabitaiones(HabitacionDTO dto);
        void errorObtenerHabitaiones(String texto);
    }
}
