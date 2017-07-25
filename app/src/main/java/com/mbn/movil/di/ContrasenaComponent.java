package com.mbn.movil.di;

import com.mbn.movil.view.impl.CambiarContrasenaActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by annelkaren on 13/07/17.
 */

@Singleton
@Component(modules = {ModuloComun.class, ModuloCambiarContrasena.class})
public interface ContrasenaComponent {

    void inyectaEnCambiarContrasenaActivity(CambiarContrasenaActivity cambiarContrasenaActivity);
}
