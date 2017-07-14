package com.mbn.movil.presenter;

import android.util.Log;

import com.mbn.movil.model.api.CambiarContrasenaCall;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Usuario;

import javax.inject.Inject;

/**
 * Created by annelkaren on 13/07/17.
 */

public class CambiarContrasenaPresenter implements CambiarContrasenaContract.Presenter{

    private static final String TAG = CambiarContrasenaPresenter.class.getSimpleName();

    private CambiarContrasenaCall call;
    private CambiarContrasenaContract.Vista vista;

    @Inject
    public CambiarContrasenaPresenter(CambiarContrasenaCall call, CambiarContrasenaContract.Vista vista) {
        this.call = call;
        this.vista = vista;
    }

    @Override
    public void cambiarContrasena(String correo) {
        call.cambiarContrasena(correo, this);
    }

    @Override
    public void exitoEnviarCorreo(String mensaje) {
        vista.mostrarPantallaInicio(mensaje);

    }

    @Override
    public void errorEnviarCorreo(String mensaje) {
        vista.mostrarError(mensaje);
    }
}
