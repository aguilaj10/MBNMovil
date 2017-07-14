package com.mbn.movil.presenter;

import android.util.Log;

import com.mbn.movil.model.api.RegistrarUsuarioCall;
import com.mbn.movil.model.entities.Usuario;

import javax.inject.Inject;

/**
 * Created by jonathan on 11/07/17.
 */

public class RegistrarUsuarioPresenter implements RegistrarUsuarioContract.Presenter {
    private static final String TAG = RegistrarUsuarioPresenter.class.getSimpleName();
    private RegistrarUsuarioCall call;
    private RegistrarUsuarioContract.Vista vista;

    @Inject
    public RegistrarUsuarioPresenter(RegistrarUsuarioCall call, RegistrarUsuarioContract.Vista vista) {
        this.call = call;
        this.vista = vista;
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        Log.d(TAG, "Registrar usuario:  " + usuario.usuario);
        this.call.registrarUsuario(usuario, this);
    }

    @Override
    public void registrarUsuarioSuccess(String usuario) {
        Log.d(TAG, "Registrar usuario: SUCCESS: " + usuario);
        this.vista.mostrarChulada();
    }

    @Override
    public void registrarUsuarioError(String usuario) {
        Log.d(TAG, "Registrar usuario: Error: " + usuario);
    }
}
