package com.mbn.movil.model.api;

import com.mbn.movil.model.dto.AutomovilDTO;
<<<<<<< .merge_file_QfHiW5
=======
import com.mbn.movil.model.dto.EdificioDTO;
import com.mbn.movil.model.dto.HabitacionDTO;
import com.mbn.movil.model.dto.ReservaDTO;
>>>>>>> .merge_file_2tEEVU
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Usuario;

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


    @POST ("mbn-service/ws/guardarAutomovil/")
    Call<AutomovilDTO> guardarAutomovil(@Body AutomovilDTO dto);

    @GET("mbn-service/ws/obtenerUsuarios/")
    Call<UsuarioDTO> buscarUsuarios();

    @POST ("mbn-service/ws/iniciarSesion/")
    Call<UsuarioDTO> iniciarSesion(@Body UsuarioDTO dto);

    @POST ("mbn-service/ws/iniciarSesion/")
    Call<ResponseBody> registrarUsuario(@Body UsuarioDTO dto);

    @GET("mbn-service/ws/cambiarContrasena")
    Call<UsuarioDTO> cambiarContrasena(@Query("correo") String correo);

    @GET("mbn-service/ws/buscarUsuario")
    Call<UsuarioDTO> buscarUsuario(@Query("cadena") String cadena);

    @GET("mbn-service/ws/obtenerEdificios/")
    Call<EdificioDTO> obtenerEdificios();

    @GET("mbn-service/ws/obtenerHabitacionesId/")
    Call<HabitacionDTO> obtenerHabitaciones(@Body EdificioDTO dto);

    @POST ("mbn-service/ws/guardarReserva/")
    Call<ReservaDTO> guardarReserva(@Body ReservaDTO dto);

    @POST ("mbn-service/ws/actualizarContrasena/")
    Call<UsuarioDTO> actualizarContrasena(@Body UsuarioDTO dto);

}
