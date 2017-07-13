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

    @GET("mbn-service/ws/obtenerEdificios/")
    Call<EdificioDTO> obtenerEdificios();

    @GET("mbn-service/ws/obtenerHabitacionesId/")
    Call<HabitacionDTO> obtenerHabitaciones(@Body int id);
}
