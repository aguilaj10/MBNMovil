package com.mbn.movil.model.api;

import android.util.Log;
import com.mbn.movil.presenter.RegistrarUsuarioContract;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Usuario;
import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 7/12/2017.
 */

public class RegistrarUsuarioCall {
    public static final String TAG = RegistrarUsuarioCall.class.getSimpleName();
    private MBNMovilAPI api;

    public RegistrarUsuarioCall(MBNMovilAPI api) {this.api = api;}

    public void ObtenerUsuario(Usuario usuario, final RegistrarUsuarioContract.Presenter listener){
        UsuarioDTO dto = new UsuarioDTO();
        dto.usuario = usuario;
        Call<ResponseBody> call = api.registrarUsuario(dto);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + response.body());
                        listener.exitoRegistrarUsuario(response.body().string());
                    } else {
                        Log.e(TAG, "onResponse: Error: " + response.message());
                        listener.errorRegistrarUsuario(response.message());
                    }
                } catch (IOException e) {
                    listener.errorRegistrarUsuario(e.getMessage());
                    Log.e(TAG, "onResponse: Error al llamar el listener", e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.errorRegistrarUsuario(t.getMessage());
            }
        });
    }
}
