package com.mbn.movil.presenter;

import com.mbn.movil.model.dto.EdificioDTO;
import com.mbn.movil.model.dto.HabitacionDTO;
import com.mbn.movil.model.dto.ReservaDTO;
import com.mbn.movil.model.entities.Edificio;
import com.mbn.movil.model.entities.Reserva;

/**
 * Created by lenovo on 14/07/2017.
 */

public interface ReservacionesContract {
    interface Vista {
        void mostrarPantallaReservas();
        void mostrarError();
        void llenarListaEdificios(EdificioDTO dto);
        void llenarListaHabitaciones(HabitacionDTO dto);
    }

    interface Presenter {
        void obtenerEdificios();
        void obtenerHabitaiones(Edificio edif, String fechaInicio, String fechaFin);
        void guardarReserva();
        //Callbacks
        void exitoObtenerEdificos(EdificioDTO dto);
        void errorObtenerEdificos(EdificioDTO dto);
        void errorObtenerEdificos(String texto);

        void exitoObtenerHabitaciones(HabitacionDTO dto);
        void errorObtenerHabitaciones(HabitacionDTO dto);
        void errorObtenerHabitaciones(String texto);

        void exitoGuardarReserva(ReservaDTO dto);
        void errorGuardarReserva(ReservaDTO dto);
        void errorGuardarReserva(String dto);
    }
}
