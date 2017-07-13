package com.mbn.movil.presenter;

import android.util.Log;

import com.mbn.movil.model.api.IniciarSesionCall;
import com.mbn.movil.model.dto.UsuarioDTO;
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
    public void registrarUsuario() {

    }

    @Override
    public void recuperarContrasena() {

    }

    @Override
    public void exitoIniciarSesion(UsuarioDTO dto) {
        Log.d(TAG, "exitoIniciarSesion: Mensaje: " + dto.usuario.usuario);
        vista.mostrarPantallaInicio(dto);
    }

    @Override
    public void errorIniciarSesion(String mensaje) {
        Log.d(TAG, "errorIniciarSesion: Mensaje: " + mensaje);
        vista.mostrarError(mensaje);
    }
}
