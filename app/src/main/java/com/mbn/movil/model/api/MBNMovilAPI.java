package com.mbn.movil.model.api;

import com.mbn.movil.model.dto.UsuarioDTO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jonathan on 11/07/17.
 */

public interface MBNMovilAPI {

    @POST ("mbn-service/ws/iniciarSesion/")
    Call<UsuarioDTO> iniciarSesion(@Body UsuarioDTO dto);

    @GET("cambiarContrasena")
    Call<UsuarioDTO> cambiarContrasena(@Query("correo") String correo);
}
