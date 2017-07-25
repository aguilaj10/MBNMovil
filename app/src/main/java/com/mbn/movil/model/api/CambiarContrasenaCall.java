package com.mbn.movil.model.api;

import android.util.Log;

import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.presenter.CambiarContrasenaContract;
import com.mbn.movil.presenter.IniciarSesionContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by annelkaren on 13/07/17.
 */

public class CambiarContrasenaCall {
    private static final String TAG = CambiarContrasenaCall.class.getSimpleName();
    private MBNMovilAPI api;

    public CambiarContrasenaCall(MBNMovilAPI api) {
        this.api = api;
    }

    public void cambiarContrasena(String correo, final CambiarContrasenaContract.Presenter listener){
        Call<UsuarioDTO> call = api.cambiarContrasena(correo);
        call.enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, Response<UsuarioDTO> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + response.body());
                        if(response.body().tipoMensaje == 3 ) {
                            listener.exitoEnviarCorreo(response.body().codigoMensaje);
                        } else {
                            listener.errorEnviarCorreo(response.body().codigoMensaje);
                        }
                    } else {
                        listener.errorEnviarCorreo(response.message());
                    }
                } catch (Exception e) {
                    listener.errorEnviarCorreo(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<UsuarioDTO> call, Throwable t) {
                listener.errorEnviarCorreo(t.getMessage());
            }
        });

    }
}
