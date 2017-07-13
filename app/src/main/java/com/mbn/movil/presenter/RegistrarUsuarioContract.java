package com.mbn.movil.presenter;

/**
 * Created by admin on 7/12/2017.
 */

public interface RegistrarUsuarioContract {

    interface Presenter {
        void registrarUsuario(String usuario, String contrasena, String nombre, String apellidos, String estado);
        void registrarUsuario();


        //Callbacks
        void exitoRegistrarUsuario(String mensaje);
        void errorRegistrarUsuario(String mensaje);
    }
}
