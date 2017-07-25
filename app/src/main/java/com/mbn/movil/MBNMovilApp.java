package com.mbn.movil;

import android.app.Application;

import com.mbn.movil.model.dto.UsuarioDTO;


/**
 * Created by jonathan on 6/07/17.
 */

public class MBNMovilApp extends Application {
    public static UsuarioDTO dto;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        dto = null;
    }
}
