package com.mbn.movil.di;

import android.app.Application;

import com.mbn.movil.di.scope.CustomScope;
import com.mbn.movil.model.api.IniciarSesionCall;
import com.mbn.movil.model.api.MBNMovilAPI;
import com.mbn.movil.model.api.RetrofitClient;
import com.mbn.movil.presenter.IniciarSesionContract;
import com.mbn.movil.presenter.IniciarSesionPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by jonathan on 6/07/17.
 */

@Module
public class ModuloUsuarios {
    private final IniciarSesionContract.Vista vista;
    private final Application app;

    public ModuloUsuarios(IniciarSesionContract.Vista vista, Application app) {
        this.vista = vista;
        this.app = app;
    }

    @Provides
    @Singleton
    public IniciarSesionContract.Vista providesVista() {
        return vista;
    }

    @Provides
    @Singleton
    public IniciarSesionContract.Presenter providesPresenter(IniciarSesionCall call) {
        return new IniciarSesionPresenter(call, vista);
    }

    @Provides
    @Singleton
    public IniciarSesionCall providesCall(MBNMovilAPI api) {
        return new IniciarSesionCall(api);
    }

    @Provides
    @Singleton
    public Cache providesCache () {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(app.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        client.addInterceptor(logging);
        return client.build();
    }

    @Provides
    @Singleton
    public MBNMovilAPI providesAPI (OkHttpClient okHttpClient) {
        return new RetrofitClient().crearCliente(okHttpClient);
    }
}
