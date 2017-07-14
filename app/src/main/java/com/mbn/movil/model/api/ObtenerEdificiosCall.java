package com.mbn.movil.model.api;

import android.util.Log;

import com.mbn.movil.model.dto.EdificioDTO;
import com.mbn.movil.model.dto.HabitacionDTO;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Edificio;
import com.mbn.movil.model.entities.Habitacion;
import com.mbn.movil.model.entities.Usuario;
import com.mbn.movil.presenter.IniciarSesionContract;
import com.mbn.movil.presenter.ObtenerEdificiosContract;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 12/07/2017.
 */

public class ObtenerEdificiosCall {
    private static final String TAG = ObtenerEdificiosCall.class.getSimpleName();
    private MBNMovilAPI api;

    public ObtenerEdificiosCall(MBNMovilAPI api) {
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
}
