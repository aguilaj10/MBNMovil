package com.mbn.movil.di;

import android.app.Application;

import com.mbn.movil.model.api.MBNMovilAPI;
import com.mbn.movil.model.api.RetrofitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by macuco on 12/07/17.
 */
@Module
public class ModuloComun {

    private final Application app;

    public ModuloComun(Application app) {
        this.app = app;
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
