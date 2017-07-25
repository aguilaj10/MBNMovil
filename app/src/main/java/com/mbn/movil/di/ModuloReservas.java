package com.mbn.movil.di;

import com.mbn.movil.model.api.MBNMovilAPI;
import com.mbn.movil.model.api.ReservacionesCall;
import com.mbn.movil.presenter.ReservacionesContract;
import com.mbn.movil.presenter.ReservacionesPresenter;
import com.mbn.movil.view.impl.ReservacionesActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jonathan on 6/07/17.
 */

@Module
public class ModuloReservas {
        private final ReservacionesContract.Vista vista;

        public ModuloReservas(ReservacionesContract.Vista vista){
            this.vista = vista;
        }

        @Provides
        @Singleton
        public ReservacionesContract.Vista providesVista(){return vista;}

        @Provides
        @Singleton
        public ReservacionesContract.Presenter providesPresenter(ReservacionesCall call, ReservacionesContract.Vista vista){
            return new ReservacionesPresenter(call, vista);
        }

        @Provides
        @Singleton
        public ReservacionesCall providesCall(MBNMovilAPI api){
            return new ReservacionesCall(api);
        }


}
