package com.mbn.movil.model.api;

import android.util.Log;

import com.mbn.movil.model.dto.HabitacionDTO;
import com.mbn.movil.model.entities.Habitacion;
import com.mbn.movil.presenter.ObtenerHabitacionesContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 12/07/2017.
 */

public class ObtenerHabitacionesCall {
    private static final String TAG = ObtenerHabitacionesCall.class.getSimpleName();
    private MBNMovilAPI api;
    private  int id;
    public ObtenerHabitacionesCall(MBNMovilAPI api) {
        this.api = api;
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
}
