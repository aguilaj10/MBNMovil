package com.mbn.movil.presenter;

import com.mbn.movil.model.api.ReservacionesCall;
import com.mbn.movil.model.dto.EdificioDTO;
import com.mbn.movil.model.dto.HabitacionDTO;
import com.mbn.movil.model.dto.ReservaDTO;
import com.mbn.movil.model.entities.Edificio;

import javax.inject.Inject;

/**
 * Created by lenovo on 14/07/2017.
 */

public class ReservacionesPresenter implements ReservacionesContract.Presenter {
    private ReservacionesCall call;
    private ReservacionesContract.Vista vista;

    @Inject
    public ReservacionesPresenter (ReservacionesCall call,ReservacionesContract.Vista vista){
        this.call = call;
        this.vista = vista;
    }

    @Override
    public void obtenerEdificios() {
        call.obtenerEdificios(null, this);
    }

    @Override
    public void obtenerHabitaiones(Edificio edif, String fechaInicio, String fechaFin) {
        call.obtenerHabitaciones(edif, fechaInicio, fechaFin, this);
    }

    @Override
    public void guardarReserva() {

    }


    @Override
    public void exitoObtenerEdificos(EdificioDTO dto) {
        vista.llenarListaEdificios(dto);
    }

    @Override
    public void errorObtenerEdificos(EdificioDTO dto) {

    }

    @Override
    public void errorObtenerEdificos(String texto) {

    }

    @Override
    public void exitoObtenerHabitaciones(HabitacionDTO dto) {
        vista.llenarListaHabitaciones(dto);
    }

    @Override
    public void errorObtenerHabitaciones(HabitacionDTO dto) {

    }

    @Override
    public void errorObtenerHabitaciones(String texto) {

    }

    @Override
    public void exitoGuardarReserva(ReservaDTO dto) {

    }

    @Override
    public void errorGuardarReserva(ReservaDTO dto) {

    }

    @Override
    public void errorGuardarReserva(String dto) {

    }
}
