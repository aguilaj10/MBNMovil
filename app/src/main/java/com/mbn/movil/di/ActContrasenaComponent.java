package com.mbn.movil.di;

import com.mbn.movil.view.impl.ActualizarContrasenaActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by annelkaren on 14/07/17.
 */

@Singleton
@Component(modules = {ModuloComun.class, ModuloActContrasena.class})
public interface ActContrasenaComponent {
    void inyectaEnActContrasenaActivity(ActualizarContrasenaActivity actualizarContrasenaActivity);
}
