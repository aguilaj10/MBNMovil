package com.mbn.movil.di;

import com.mbn.movil.view.impl.ReservacionesActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lenovo on 14/07/2017.
 */
@Singleton
@Component(modules = {ModuloReservas.class, ModuloComun.class})
public interface ReservasComponent {
 void inyectarEnResercacionesActivity(ReservacionesActivity reservacionesActivity);
}
