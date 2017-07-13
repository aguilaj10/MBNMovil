package com.mbn.movil.model.api;

import com.mbn.movil.model.dto.UsuarioDTO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jonathan on 11/07/17.
 */

public interface MBNMovilAPI {

    @POST ("mbn-service/ws/iniciarSesion/")
    Call<ResponseBody> iniciarSesion(@Body UsuarioDTO dto);

    @POST ("mbn-service/ws/registrarUsuario/")
    Call<ResponseBody> registrarUsuario(@Body UsuarioDTO dto);

}
