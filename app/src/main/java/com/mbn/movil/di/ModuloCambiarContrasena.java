package com.mbn.movil.di;

import com.mbn.movil.model.api.CambiarContrasenaCall;
import com.mbn.movil.model.api.MBNMovilAPI;
import com.mbn.movil.presenter.CambiarContrasenaContract;
import com.mbn.movil.presenter.CambiarContrasenaPresenter;
import com.mbn.movil.view.impl.CambiarContrasenaActivity;
import com.mbn.movil.view.impl.ProgresoModal;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by annelkaren on 13/07/17.
 */

@Module
public class ModuloCambiarContrasena {

    private final CambiarContrasenaContract.Vista vista;

    public ModuloCambiarContrasena(CambiarContrasenaContract.Vista vista) {
        this.vista = vista;
    }

    @Provides
    @Singleton
    public CambiarContrasenaContract.Vista providesVista() {
        return vista;
    }

    @Provides
    @Singleton
    public CambiarContrasenaContract.Presenter providesPresenter(CambiarContrasenaCall call) {
        return new CambiarContrasenaPresenter(call, vista);
    }

    @Provides
    @Singleton
    public CambiarContrasenaCall providesCall(MBNMovilAPI api) {
        return new CambiarContrasenaCall(api);
    }

    @Provides
    @Singleton
    public ProgresoModal providesModal(){
        return new ProgresoModal((CambiarContrasenaActivity) vista, 100);
    }
}
