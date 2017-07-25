package com.mbn.movil.di;

import com.mbn.movil.model.api.IniciarSesionCall;
import com.mbn.movil.model.api.RegistrarUsuarioCall;
import com.mbn.movil.model.api.MBNMovilAPI;
import com.mbn.movil.presenter.IniciarSesionContract;
import com.mbn.movil.presenter.IniciarSesionPresenter;
import com.mbn.movil.presenter.RegistrarUsuarioContract;
import com.mbn.movil.presenter.RegistrarUsuarioPresenter;
import com.mbn.movil.view.impl.RegistrarUsuario;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jonathan on 6/07/17.
 */

@Module
public class ModuloUsuarios {
    private IniciarSesionContract.Vista vista;
    private RegistrarUsuarioContract.Vista vistaRegistrarUsuario;

    public ModuloUsuarios(IniciarSesionContract.Vista vista) {
        this.vista = vista;
    }

    public ModuloUsuarios(RegistrarUsuarioContract.Vista vista) {
        this.vistaRegistrarUsuario = vista;
    }

    // ----- Registrar usuarios -------------
    @Provides
    @Singleton
    public RegistrarUsuarioContract.Vista providesVistaRegistrarUsuario() {
        return vistaRegistrarUsuario;
    }

    @Provides
    @Singleton
    public RegistrarUsuarioContract.Presenter providesPresenterRegistrarUsuario(RegistrarUsuarioCall call) {
        return new RegistrarUsuarioPresenter(call, vistaRegistrarUsuario);
    }
    // -------------------------------------------


    @Provides
    @Singleton
    public IniciarSesionContract.Vista providesVista() {
        return vista;
    }

    @Provides
    @Singleton
    public IniciarSesionContract.Presenter providesPresenter(IniciarSesionCall call) {
        return new IniciarSesionPresenter(call, vista);
    }

    @Provides
    @Singleton
    public IniciarSesionCall providesCall(MBNMovilAPI api) {
        return new IniciarSesionCall(api);
    }

    @Provides
    @Singleton
    public RegistrarUsuarioCall providesJmpCall(MBNMovilAPI api) {
        return new RegistrarUsuarioCall(api);
    }
}
