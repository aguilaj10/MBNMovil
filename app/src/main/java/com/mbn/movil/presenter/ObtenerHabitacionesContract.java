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
        void exitoObtenerHabitaciones(HabitacionDTO dto);
        void errorObtenerHabitaciones(HabitacionDTO dto);
        void errorObtenerHabitaciones(String texto);
    }
}
