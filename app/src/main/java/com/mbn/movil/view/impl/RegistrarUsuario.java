package com.mbn.movil.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.mbn.movil.R;
import com.mbn.movil.di.DaggerMainComponent;
import com.mbn.movil.di.ModuloComun;
import com.mbn.movil.di.ModuloUsuarios;
import com.mbn.movil.model.entities.Usuario;
import com.mbn.movil.presenter.RegistrarUsuarioContract;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrarUsuario extends AppCompatActivity implements RegistrarUsuarioContract.Vista {

    private static final String TAG = RegistrarUsuario.class.getSimpleName();

    @Inject
    RegistrarUsuarioContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        ButterKnife.bind(this);

        DaggerMainComponent.builder()
                .moduloComun(new ModuloComun(getApplication()))
                .moduloUsuarios(new ModuloUsuarios(this))
                .build().inyectaEnActivity(this);
    }

    @OnClick(R.id.buttonRegistrarUsuario)
    public void registrarUsuario(){
        Log.d(TAG, "registrarUsuario: ");
        Usuario u = new Usuario();
        u.usuario = "gonzalez.annel@mbn.com.mx";
        u.contrasena = "pass";
        presenter.registrarUsuario(u);
    }

    @Override
    public void mostrarChulada() {
        Log.d(TAG, "mostrarChulada: ");
    }
}
