package com.mbn.movil.presenter;

import com.mbn.movil.model.entities.Usuario;

/**
 * Created by jonathan on 11/07/17.
 */

public interface RegistrarUsuarioContract {
    interface Vista {
        void mostrarChulada();
    }

    interface Presenter {
        void registrarUsuario(Usuario usuario);
        void registrarUsuarioError(String usuario);
        void registrarUsuarioSuccess(String response);
    }
}
