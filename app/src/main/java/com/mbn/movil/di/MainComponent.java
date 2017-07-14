package com.mbn.movil.di;

import android.app.Activity;

import com.mbn.movil.MBNMovilApp;
import com.mbn.movil.presenter.IniciarSesionContract;
import com.mbn.movil.view.impl.MainActivity;
import com.mbn.movil.view.impl.RegistrarUsuario;
import com.mbn.movil.view.impl.RegistrarAutoActivity;
import com.mbn.movil.view.impl.ReservacionesActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jonathan on 6/07/17.
 */

@Singleton
@Component(modules = { ModuloUsuarios.class, ModuloComun.class})
public interface MainComponent {

    void inject(Object injectable);

    void inyectaEnMainActivity(MainActivity mainActivity);
    void inyectaEnActivity(RegistrarUsuario cualquiera);

}
