package com.mbn.movil.model.api;

import android.util.Log;

import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Usuario;
import com.mbn.movil.presenter.IniciarSesionContract;

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
        Call<UsuarioDTO> call = api.iniciarSesion(dto);
        call.enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, Response<UsuarioDTO> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + response.body());
                        if(response.body().tipoMensaje == 0 ) {
                            listener.exitoIniciarSesion(response.body());
                        } else {
                            listener.errorIniciarSesion(response.body().codigoMensaje);
                        }
                    } else {
                        Log.e(TAG, "onResponse: Error: " + response.message());
                        listener.errorIniciarSesion(response.message());
                    }
                } catch (Exception e) {
                    listener.errorIniciarSesion(e.getMessage());
                    Log.e(TAG, "onResponse: Error al llamar el listener", e);
                }
            }

            @Override
            public void onFailure(Call<UsuarioDTO> call, Throwable t) {
                listener.errorIniciarSesion(t.getMessage());
            }
        });
    }
}
