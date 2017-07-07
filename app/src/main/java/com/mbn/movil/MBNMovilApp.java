package com.mbn.movil;

import android.app.Application;

import com.mbn.movil.di.DaggerMainComponent;
import com.mbn.movil.di.MainComponent;

/**
 * Created by jonathan on 6/07/17.
 */

public class MBNMovilApp extends Application {
    private static MainComponent daggerComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        daggerComponent = DaggerMainComponent.builder().build();
    }

    public static void injectComponent(Object injectable) {
        daggerComponent.inject(injectable);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        daggerComponent = null;
    }
}
