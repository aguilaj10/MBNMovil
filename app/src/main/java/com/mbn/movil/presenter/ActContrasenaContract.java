package com.mbn.movil.presenter;

import com.mbn.movil.model.dto.UsuarioDTO;

/**
 * Created by annelkaren on 14/07/17.
 */

public interface ActContrasenaContract {

    interface Vista extends BaseVista{
        void mostrarPantallaInicio(String mensaje);
        void mostrarError(String error);
        void activaCampos(UsuarioDTO usuario);
    }

    interface Presenter {
        void actContrasena(String cadena);

        void exitoActContrasena(UsuarioDTO usuario);
        void errorActContrasena(String mensaje);
    }
}
