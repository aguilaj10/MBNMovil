package com.mbn.movil.di;

import com.mbn.movil.MBNMovilApp;
import com.mbn.movil.presenter.IniciarSesionContract;
import com.mbn.movil.view.impl.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jonathan on 6/07/17.
 */

@Singleton
@Component(modules = {ModuloReservas.class, ModuloUsuarios.class, ModuloViajes.class})
public interface MainComponent {

    void inject(Object injectable);

    void inyectaEnMainActivity(MainActivity mainActivity);
}
