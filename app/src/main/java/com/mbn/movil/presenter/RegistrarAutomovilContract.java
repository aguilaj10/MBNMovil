package com.mbn.movil.presenter;

import com.mbn.movil.model.dto.AutomovilDTO;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Automovil;
import com.mbn.movil.model.entities.Usuario;

import java.util.List;

/**
 * Created by MBN USER on 12/07/2017.
 */

public interface RegistrarAutomovilContract {
    interface Vista extends BaseVista{
        void mostrarExitoBuscarUsuarios(List<Usuario> usuarios);
        void mostrarErrorBuscarUsuarios();

        void mostrarExitoGuardarAutomovil();
        void mostrarErrorGuardarAutomovil();
    }

    interface presenter{
        void buscarConductores(UsuarioDTO usuarioDTO);
        void exitoBuscarConductores(List<Usuario> usuarios);
        void errorBuscarConductores();

        void guardarAutomovil(AutomovilDTO automovilDTO);
        void exitoGuardarAutomovil();
        void errorGuardarAutomovil();
    }
}
