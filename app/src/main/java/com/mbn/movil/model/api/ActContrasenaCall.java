package com.mbn.movil.model.api;

import android.util.Log;

import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.presenter.ActContrasenaContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by annelkaren on 14/07/17.
 */

public class ActContrasenaCall {

    private static final String TAG = ActContrasenaCall.class.getSimpleName();
    private MBNMovilAPI api;

    public ActContrasenaCall(MBNMovilAPI api) {
        this.api = api;
    }

    public void actContrasena(String cadena, final ActContrasenaContract.Presenter listener){
        Call<UsuarioDTO> call = api.buscarUsuario(cadena); //Aqui llama al servicio, paso de parametros
        call.enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, Response<UsuarioDTO> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + response.body());
                        if(response.body().tipoMensaje == 0 ) {
                            listener.exitoActContrasena(response.body());
                        } else {
                            listener.errorActContrasena(response.body().codigoMensaje);
                        }
                    } else {
                        listener.errorActContrasena(response.message());
                    }
                } catch (Exception e) {
                    listener.errorActContrasena(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<UsuarioDTO> call, Throwable t) {
                listener.errorActContrasena(t.getMessage());
            }
        });

    }

    public void enviarUsuario(UsuarioDTO usuario, final ActContrasenaContract.Presenter listener){
        Call<UsuarioDTO> call = api.actualizarContrasena(usuario); //Aqui llama al servicio, paso de parametros
        call.enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, Response<UsuarioDTO> response) {
                try {
                    if (response.isSuccessful()) {
                        if(response.body().tipoMensaje == 3 ) {
                            listener.exitoEnviarUsuario(response.body());
                        } else {
                            listener.errorActContrasena(response.body().codigoMensaje);
                        }
                    } else {
                        Log.d(TAG, "onResponse: Error");
                    }
                } catch (Exception e) {
                    listener.errorActContrasena(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<UsuarioDTO> call, Throwable t) {
                listener.errorActContrasena(t.getMessage());
            }
        });

    }
}
