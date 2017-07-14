package com.mbn.movil.model.api;

import android.util.Log;

import com.mbn.movil.model.dto.AutomovilDTO;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Automovil;
import com.mbn.movil.model.entities.Usuario;
import com.mbn.movil.presenter.RegistrarAutomovilContract;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MBN USER on 12/07/2017.
 */

public class RegistrarAutomovilCall {
    private static final String TAG = RegistrarAutomovilCall.class.getSimpleName();
    private MBNMovilAPI api;

    public RegistrarAutomovilCall(MBNMovilAPI api){
        this.api=api;
    }

    public void guardarAutomovil(AutomovilDTO automovilDTO, final RegistrarAutomovilContract.presenter listener){
        Call<AutomovilDTO> call = api.guardarAutomovil(automovilDTO);
        call.enqueue(new Callback<AutomovilDTO>() {
            @Override
            public void onResponse(Call<AutomovilDTO> call, Response<AutomovilDTO> responseAutomovilDTO) {
                Log.d(TAG, "CODIGO: ==============>"+responseAutomovilDTO.body().getTipoMensaje());
                    if (responseAutomovilDTO.isSuccessful() && responseAutomovilDTO.body().getTipoMensaje()==3){
                        Log.d(TAG, "Se guardo el automovil satisfactoriamente :)");
                        listener.exitoGuardarAutomovil();
                    }else{
                        Log.d(TAG, "Error guardando el automovil :(");
                        listener.errorGuardarAutomovil();
                    }
            }

            @Override
            public void onFailure(Call<AutomovilDTO> call, Throwable t) {
                listener.errorGuardarAutomovil();
            }
        });
    }

    public void buscarUsuarios(final RegistrarAutomovilContract.presenter listener){
        Call<UsuarioDTO> call = api.buscarUsuarios();
        call.enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, Response<UsuarioDTO> response) {
                Log.d(TAG, "Exito en solicitud!");
                if (response.isSuccessful()){
                    listener.exitoBuscarUsuarios(response.body().usuarios);
                }else{
                    listener.errorBuscarUsuarios();
                }
            }

            @Override
            public void onFailure(Call<UsuarioDTO> call, Throwable t) {
                Log.d(TAG, "Error obteniendo los usuarios");
                listener.errorBuscarUsuarios();
            }
        });

    }
}
