package com.mbn.movil.presenter;

import com.mbn.movil.model.dto.UsuarioDTO;

/**
 * Created by jonathan on 11/07/17.
 */

public interface IniciarSesionContract {
    interface Vista {
        void mostrarPantallaInicio(UsuarioDTO dto);
        void mostrarError(String error);
    }

    interface Presenter {
        void iniciarSesion(String usuario, String contrasena);
        void registrarUsuario();
        void recuperarContrasena();

        //Callbacks
        void exitoIniciarSesion(UsuarioDTO mensaje);
        void errorIniciarSesion(String mensaje);
    }
}
