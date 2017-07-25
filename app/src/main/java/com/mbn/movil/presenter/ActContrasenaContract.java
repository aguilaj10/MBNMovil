package com.mbn.movil.presenter;

import com.mbn.movil.model.dto.UsuarioDTO;

/**
 * Created by annelkaren on 14/07/17.
 */

public interface ActContrasenaContract {

    interface Vista extends BaseVista{
        void mostrarError(String error);
        void mostrarPantallaInicio(String mensaje);
        void activaCampos(UsuarioDTO usuario);
    }

    interface Presenter {
        void actContrasena(String cadena);
        void enviarUsuario(UsuarioDTO usuario);
        void exitoActContrasena(UsuarioDTO usuario);
        void exitoEnviarUsuario(UsuarioDTO usuario);
        void errorActContrasena(String mensaje);
    }
}
