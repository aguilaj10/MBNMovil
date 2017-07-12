package com.mbn.movil.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.mbn.movil.R;
import com.mbn.movil.di.DaggerMainComponent;
import com.mbn.movil.di.ModuloUsuarios;
import com.mbn.movil.presenter.IniciarSesionContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IniciarSesionContract.Vista {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.usuario)
    EditText usuario;
    @BindView(R.id.contrasena)
    EditText contrasena;

    @Inject
    IniciarSesionContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DaggerMainComponent.builder()
                .moduloUsuarios(new ModuloUsuarios(this, getApplication()))
                .build().inyectaEnMainActivity(this);

        Log.d(TAG, "onCreate: ");
    }

    @OnClick (R.id.btnIniciarSesion)
    public void inicarSesion(View btn) {
        presenter.iniciarSesion(usuario.getText().toString(), contrasena.getText().toString());
    }

    @Override
    public void mostrarPantallaInicio() {

    }

    @Override
    public void mostrarError() {

    }
}
