package com.mbn.movil.model.api;

import android.app.Application;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mbn.movil.config.ConstantesEstaticas.END_POINT;

/**
 * Created by jonathan on 11/07/17.
 */

public class RetrofitClient {

    public MBNMovilAPI crearCliente( OkHttpClient client) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MBNMovilAPI.class);
    }
}
