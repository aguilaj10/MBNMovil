package com.mbn.movil.presenter;

import android.util.Log;

import com.mbn.movil.model.api.IniciarSesionCall;
import com.mbn.movil.model.entities.Usuario;

import javax.inject.Inject;

/**
 * Created by jonathan on 11/07/17.
 */

public class IniciarSesionPresenter implements IniciarSesionContract.Presenter {
    private static final String TAG = IniciarSesionPresenter.class.getSimpleName();
    private IniciarSesionCall call;
    private IniciarSesionContract.Vista vista;

    @Inject
    public IniciarSesionPresenter(IniciarSesionCall call, IniciarSesionContract.Vista vista) {
        this.call = call;
        this.vista = vista;
    }

    @Override
    public void iniciarSesion(String usuario, String contrasena) {
        Usuario usr = new Usuario();
        usr.usuario = usuario;
        usr.contrasena = contrasena;
        call.iniciarSesion(usr, this);
    }


    @Override
    public void recuperarContrasena() {

    }

    @Override
    public void exitoIniciarSesion(String mensaje) {
        Log.d(TAG, "exitoIniciarSesion: Mensaje: " + mensaje);
        vista.mostrarPantallaInicio();
    }

    @Override
    public void errorIniciarSesion(String mensaje) {
        Log.d(TAG, "errorIniciarSesion: Mensaje: " + mensaje);
        vista.mostrarError();
    }
}
