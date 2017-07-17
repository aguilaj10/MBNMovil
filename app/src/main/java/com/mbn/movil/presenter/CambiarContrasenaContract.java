package com.mbn.movil.presenter;

import com.mbn.movil.model.dto.UsuarioDTO;

/**
 * Created by annelkaren on 13/07/17.
 */

public interface CambiarContrasenaContract {
    interface Vista extends BaseVista{
        void mostrarPantallaInicio(String mensaje);
        void mostrarError(String error);
    }

    interface Presenter {
        void cambiarContrasena(String correo);

        void exitoEnviarCorreo(String mensaje);
        void errorEnviarCorreo(String mensaje);
    }

}
