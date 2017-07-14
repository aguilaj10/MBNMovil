package com.mbn.movil.di;

import com.mbn.movil.model.api.MBNMovilAPI;
import com.mbn.movil.model.api.RegistrarAutomovilCall;
import com.mbn.movil.presenter.RegistrarAutomovilContract;
import com.mbn.movil.presenter.RegistrarAutomovilPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jonathan on 6/07/17.
 */

@Module
public class ModuloViajes {

    private final RegistrarAutomovilContract.Vista vista;

    public ModuloViajes(RegistrarAutomovilContract.Vista vista){
        this.vista = vista;
    }

    @Provides
    @Singleton
    public RegistrarAutomovilContract.Vista providesVista(){return vista;}

    @Provides
    @Singleton
    public RegistrarAutomovilContract.presenter providesPresenter(RegistrarAutomovilCall call){
        return new RegistrarAutomovilPresenter(call, vista);
    }

    @Provides
    @Singleton
    public RegistrarAutomovilCall providesCall(MBNMovilAPI api){
        return new RegistrarAutomovilCall(api);
    }

}
