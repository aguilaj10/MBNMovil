package com.mbn.movil.presenter;

/**
 * Created by annelkaren on 14/07/17.
 */

public interface ActContrasenaContract {

    interface Vista{
        void mostrarPantallaInicio(String mensaje);
        void mostrarError(String error);
        void mostrarModal();
        void cerrarModal();
    }

    interface Presenter {
        void actContrasena(String cadena);

        void exitoActContrasena(String mensaje);
        void errorActContrasena(String mensaje);
    }
}
