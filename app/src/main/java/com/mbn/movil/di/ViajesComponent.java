package com.mbn.movil.di;

import com.mbn.movil.view.impl.RegistrarAutoActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by MBN USER on 14/07/2017.
 */

@Singleton
@Component(modules = {ModuloViajes.class, ModuloComun.class})
public interface ViajesComponent {
    void inyectaEnRegistrarAutoActivity(RegistrarAutoActivity registrarAutoActivity);
}
