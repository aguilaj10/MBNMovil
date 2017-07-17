package com.mbn.movil.presenter;

import android.util.Log;

import com.mbn.movil.model.api.RegistrarAutomovilCall;
import com.mbn.movil.model.dto.AutomovilDTO;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Automovil;
import com.mbn.movil.model.entities.Usuario;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by MBN USER on 12/07/2017.
 */

public class RegistrarAutomovilPresenter implements RegistrarAutomovilContract.presenter{
    private static String TAG = RegistrarAutomovilPresenter.class.getName();
    private RegistrarAutomovilCall Call;
    private RegistrarAutomovilContract.Vista Vista;

    @Inject
    public RegistrarAutomovilPresenter(RegistrarAutomovilCall call, RegistrarAutomovilContract.Vista vista) {
        this.Call=call;
        this.Vista=vista;
    }

    @Override
    public void buscarConductores(UsuarioDTO usuarioDTO) {
        Vista.mostrarModal();
        Call.buscarConductores(usuarioDTO, this);
    }

    @Override
    public void guardarAutomovil(AutomovilDTO automovilDTO) {
        Vista.mostrarModal();
        Call.guardarAutomovil(automovilDTO, this);
    }

    @Override
    public void exitoBuscarConductores(List<Usuario> usuarios) {
        Log.d(TAG, "Exito buscando usuarios");
        Vista.cerrarModal();
        Vista.mostrarExitoBuscarUsuarios(usuarios);
    }

    @Override
    public void errorBuscarConductores() {
        Log.d(TAG, "Error buscando usuarios");
        Vista.cerrarModal();
        Vista.mostrarErrorBuscarUsuarios();
    }

    @Override
    public void exitoGuardarAutomovil() {
        Log.d(TAG, "Exito guardando automovil");
        Vista.cerrarModal();
        Vista.mostrarExitoGuardarAutomovil();
    }

    @Override
    public void errorGuardarAutomovil() {
        Log.d(TAG, "Error guardando el automovil");
        Vista.cerrarModal();
        Vista.mostrarErrorGuardarAutomovil();
    }
}
