package com.mbn.movil.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.mbn.movil.R;
import com.mbn.movil.di.DaggerContrasenaComponent;
import com.mbn.movil.di.ModuloComun;
import com.mbn.movil.di.scope.ModuloCambiarContrasena;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.presenter.CambiarContrasenaContract;
import com.rengwuxian.materialedittext.MaterialEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CambiarContrasenaActivity extends AppCompatActivity implements CambiarContrasenaContract.Vista{
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.usuario)
    MaterialEditText usuario;

    @Inject
    CambiarContrasenaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cambiar_contrasena);

        ButterKnife.bind(this);

        DaggerContrasenaComponent.builder()
                .moduloComun(new ModuloComun(getApplication()))
                .moduloCambiarContrasena(new ModuloCambiarContrasena(this))
                .build().inyectaEnCambiarContrasenaActivity(this);
    }

    @OnClick(R.id.aceptar)
    public void cambiarContrasena(View btn) {
        if(Patterns.EMAIL_ADDRESS.matcher(usuario.getText().toString()).matches()) {
            presenter.cambiarContrasena(usuario.getText().toString());
        } else {
            Toast.makeText(this, R.string.email_error, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void mostrarPantallaInicio(String mensaje) {
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
