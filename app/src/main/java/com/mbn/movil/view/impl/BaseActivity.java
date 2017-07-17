package com.mbn.movil.view.impl;

import android.support.v7.app.AppCompatActivity;

import com.mbn.movil.presenter.BaseVista;

import javax.inject.Inject;

/**
 * Created by jonathan on 14/07/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseVista{
    @Inject
    ProgresoModal modal;

    @Override
    public void mostrarModal() {
        modal.show();
    }

    @Override
    public void cerrarModal() {
        modal.dismiss();
    }
}
