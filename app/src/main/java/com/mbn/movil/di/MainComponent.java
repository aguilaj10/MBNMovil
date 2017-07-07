package com.mbn.movil.di;

import com.mbn.movil.MBNMovilApp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jonathan on 6/07/17.
 */

@Singleton
@Component(modules = {ModuloReservas.class, ModuloUsuarios.class, ModuloViajes.class})
public interface MainComponent {

    void inject(Object injectable);
}
