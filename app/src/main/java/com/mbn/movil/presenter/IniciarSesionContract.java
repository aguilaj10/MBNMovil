package com.mbn.movil.presenter;

/**
 * Created by jonathan on 11/07/17.
 */

public interface IniciarSesionContract {
    interface Vista {
        void mostrarPantallaInicio();
        void mostrarError();
    }

    interface Presenter {
        void iniciarSesion(String usuario, String contrasena);
        void recuperarContrasena();

        //Callbacks
        void exitoIniciarSesion(String mensaje);
        void errorIniciarSesion(String mensaje);
    }
}
