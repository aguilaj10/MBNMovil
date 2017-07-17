package com.mbn.movil.presenter;

import com.mbn.movil.model.api.ActContrasenaCall;

/**
 * Created by annelkaren on 14/07/17.
 */

public class ActContrasenaPresenter implements ActContrasenaContract.Presenter{

    private static final String TAG = ActContrasenaPresenter.class.getSimpleName();

    private ActContrasenaCall call;
    private ActContrasenaContract.Vista vista;

    @Override
    public void actContrasena(String cadena) {
        vista.mostrarModal();
        call.actContrasena(cadena, this);
    }

    @Override
    public void exitoActContrasena(String mensaje) {
        vista.cerrarModal();
        vista.mostrarPantallaInicio(mensaje);
    }

    @Override
    public void errorActContrasena(String mensaje) {
        vista.cerrarModal();
        vista.mostrarError(mensaje);
    }
}
