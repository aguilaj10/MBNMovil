package com.mbn.movil.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.mbn.movil.MBNMovilApp;
import com.mbn.movil.R;
import com.mbn.movil.di.DaggerMainComponent;
import com.mbn.movil.di.ModuloComun;
import com.mbn.movil.di.ModuloUsuarios;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.presenter.IniciarSesionContract;
import com.mbn.movil.util.MD5;
import com.rengwuxian.materialedittext.MaterialEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IniciarSesionContract.Vista {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.usuario)
    MaterialEditText usuario;
    @BindView(R.id.contrasena)
    MaterialEditText contrasena;

    @Inject
    IniciarSesionContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DaggerMainComponent.builder()
                .moduloComun(new ModuloComun(getApplication()))
                .moduloUsuarios(new ModuloUsuarios(this))
                .build().inyectaEnMainActivity(this);

        Log.d(TAG, "onCreate: ");
    }

    @OnClick (R.id.btnIniciarSesion)
    public void inicarSesion(View btn) {
        if(Patterns.EMAIL_ADDRESS.matcher(usuario.getText().toString()).matches()) {
            presenter.iniciarSesion(usuario.getText().toString(), MD5.getMD5(contrasena.getText().toString()));
        } else {
            Toast.makeText(this, R.string.email_error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void mostrarPantallaInicio(UsuarioDTO dto) {
        MBNMovilApp.dto = dto;

        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.linkOlvido)
    public void mostrarPantallaCambiarContrasena(View btn){
        Intent intent = new Intent(this, CambiarContrasenaActivity.class);
        startActivity(intent);
    }

}
