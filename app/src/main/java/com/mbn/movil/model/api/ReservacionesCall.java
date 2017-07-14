package com.mbn.movil.model.api;

import android.util.Log;

import com.mbn.movil.model.dto.EdificioDTO;
import com.mbn.movil.model.dto.HabitacionDTO;
import com.mbn.movil.model.dto.ReservaDTO;
import com.mbn.movil.model.entities.Edificio;
import com.mbn.movil.model.entities.Habitacion;
import com.mbn.movil.presenter.ObtenerEdificiosContract;
import com.mbn.movil.presenter.ObtenerHabitacionesContract;
import com.mbn.movil.presenter.ReservacionesContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 14/07/2017.
 */

public class ReservacionesCall {
    private static final String TAG = ObtenerHabitacionesCall.class.getSimpleName();
    private MBNMovilAPI api;
    private int id;

    public ReservacionesCall (MBNMovilAPI api) {
        this.api = api;
    }

    public void obtenerEdificios(Edificio edificio, final ObtenerEdificiosContract.Presenter listener) {
        Call<EdificioDTO> call = api.obtenerEdificios();
        call.enqueue(new Callback<EdificioDTO>() {
            @Override
            public void onResponse(Call<EdificioDTO> call, Response<EdificioDTO> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body());
                    listener.exitoObtenerEdificos(response.body());
                } else {
                    Log.e(TAG, "onResponse: Error: " + response.message());
                    listener.errorObtenerEdificos(response.body());
                }
            }

            @Override
            public void onFailure(Call<EdificioDTO> call, Throwable t) {
                listener.errorObtenerEdificos(t.getMessage());
            }
        });
    }

    public void obtenerHabitaciones(Habitacion habitacion, final ObtenerHabitacionesContract.Presenter listener) {

        Call<HabitacionDTO> call = api.obtenerHabitaciones(id);
        call.enqueue(new Callback<HabitacionDTO>() {
            @Override
            public void onResponse(Call<HabitacionDTO> call, Response<HabitacionDTO> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body());
                    listener.exitoObtenerHabitaciones(response.body());
                } else {
                    Log.e(TAG, "onResponse: Error: " + response.message());
                    listener.errorObtenerHabitaciones(response.body());
                }
            }

            @Override
            public void onFailure(Call<HabitacionDTO> call, Throwable t) {
                listener.errorObtenerHabitaciones(t.getMessage());
            }
        });
    }

    public void guardarReservacion(ReservaDTO reservaDTO, final ReservacionesContract.Presenter listener){
        Call<ReservaDTO> call = api.guardarReserva(reservaDTO);
        call.enqueue(new Callback<ReservaDTO>() {
            @Override
            public void onResponse(Call<ReservaDTO> call, Response<ReservaDTO> responseReservaDTO) {
                Log.d(TAG, "CODIGO: ==============>"+responseReservaDTO.body().tipoMensaje);
                if (responseReservaDTO.isSuccessful() && responseReservaDTO.body().tipoMensaje==3){
                    Log.d(TAG, "Se guardo el automovil satisfactoriamente :)");
                    listener.exitoGuardarReserva(responseReservaDTO.body());
                }else{
                    Log.d(TAG, "Error guardando el automovil :(");
                    listener.errorGuardarReserva(responseReservaDTO.body());
                }
            }

            @Override
            public void onFailure(Call<ReservaDTO> call, Throwable t) {
                listener.errorGuardarReserva(t.getMessage());
            }
        });
    }
}
