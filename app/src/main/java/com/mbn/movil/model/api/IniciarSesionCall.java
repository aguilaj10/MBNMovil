package com.mbn.movil.model.api;

import android.util.Log;

import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Usuario;
import com.mbn.movil.presenter.IniciarSesionContract;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jonathan on 11/07/17.
 */

public class IniciarSesionCall {
    private static final String TAG = IniciarSesionCall.class.getSimpleName();
    private MBNMovilAPI api;

    public IniciarSesionCall(MBNMovilAPI api) {
        this.api = api;
    }

    public void iniciarSesion(Usuario usuario, final IniciarSesionContract.Presenter listener) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.usuario = usuario;
        Call<ResponseBody> call = api.iniciarSesion(dto);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + response.body());
                        listener.exitoIniciarSesion(response.body().string());
                    } else {
                        Log.e(TAG, "onResponse: Error: " + response.message());
                        listener.errorIniciarSesion(response.message());
                    }
                } catch (IOException e) {
                    listener.errorIniciarSesion(e.getMessage());
                    Log.e(TAG, "onResponse: Error al llamar el listener", e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.errorIniciarSesion(t.getMessage());
            }
        });
    }
}
