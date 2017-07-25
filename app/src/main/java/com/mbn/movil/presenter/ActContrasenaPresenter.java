package com.mbn.movil.presenter;

import com.mbn.movil.model.api.ActContrasenaCall;
import com.mbn.movil.model.dto.UsuarioDTO;

import javax.inject.Inject;

/**
 * Created by annelkaren on 14/07/17.
 */

public class ActContrasenaPresenter implements ActContrasenaContract.Presenter{

    private static final String TAG = ActContrasenaPresenter.class.getSimpleName();
    private UsuarioDTO dto;
    private ActContrasenaCall call;
    private ActContrasenaContract.Vista vista;

    @Inject
    public ActContrasenaPresenter(ActContrasenaCall call, ActContrasenaContract.Vista vista) {
        this.call = call;
        this.vista = vista;
    }

    @Override
    public void actContrasena(String cadena) {
        vista.mostrarModal();
        call.actContrasena(cadena, this);
    }

    @Override
    public void enviarUsuario(UsuarioDTO usuario) {
        vista.mostrarModal();
        call.enviarUsuario(usuario, this);
    }

    @Override
    public void exitoActContrasena(UsuarioDTO usuario) {
        vista.cerrarModal();
        vista.activaCampos(usuario);
    }

    @Override
    public void exitoEnviarUsuario(UsuarioDTO usuario) {
        vista.cerrarModal();
        vista.mostrarPantallaInicio(usuario.codigoMensaje);
    }


    @Override
    public void errorActContrasena(String mensaje) {
        vista.cerrarModal();
        vista.mostrarError(mensaje);
    }
}
