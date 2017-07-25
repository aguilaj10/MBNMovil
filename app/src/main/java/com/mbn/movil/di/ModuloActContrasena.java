package com.mbn.movil.di;

import com.mbn.movil.model.api.ActContrasenaCall;
import com.mbn.movil.model.api.MBNMovilAPI;
import com.mbn.movil.presenter.ActContrasenaContract;
import com.mbn.movil.presenter.ActContrasenaPresenter;
import com.mbn.movil.view.impl.ActualizarContrasenaActivity;
import com.mbn.movil.view.impl.ProgresoModal;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by annelkaren on 14/07/17.
 */

@Module
public class ModuloActContrasena {

    private final ActContrasenaContract.Vista vista;

    public ModuloActContrasena(ActContrasenaContract.Vista vista) {
        this.vista = vista;
    }

    @Provides
    @Singleton
    public ActContrasenaContract.Vista providesVista() {
        return vista;
    }

    @Provides
    @Singleton
    public ActContrasenaContract.Presenter providesPresenter(ActContrasenaCall call) {
        return new ActContrasenaPresenter(call, vista);
    }

    @Provides
    @Singleton
    public ActContrasenaCall providesCall(MBNMovilAPI api) {
        return new ActContrasenaCall(api);
    }

    @Provides
    @Singleton
    public ProgresoModal providesModal(){
        return new ProgresoModal((ActualizarContrasenaActivity) vista, 100);
    }
}
