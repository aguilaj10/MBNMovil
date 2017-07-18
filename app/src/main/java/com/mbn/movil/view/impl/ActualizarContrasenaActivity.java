package com.mbn.movil.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.mbn.movil.R;
import com.mbn.movil.di.DaggerActContrasenaComponent;
import com.mbn.movil.di.DaggerContrasenaComponent;
import com.mbn.movil.di.ModuloActContrasena;
import com.mbn.movil.di.ModuloComun;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.presenter.ActContrasenaContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActualizarContrasenaActivity extends BaseActivity implements ActContrasenaContract.Vista {

    public static final String TAG = ActualizarContrasenaActivity.class.getSimpleName();

    @BindView(R.id.nuevoPass)
    EditText nuevopass;

    @BindView(R.id.contrasena)
    EditText contrasena;

    @Inject
    ActContrasenaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contrasena);
        Intent data = getIntent();
        String action = data.getData().getPath();
        Log.d(TAG, "onCreate: la cadena a enviar es:" + cortarCadena(action));

        ButterKnife.bind(this);

        DaggerActContrasenaComponent.builder()
                .moduloComun(new ModuloComun(getApplication()))
                .moduloActContrasena(new ModuloActContrasena(this))
                .build().inyectaEnActContrasenaActivity(this);

        nuevopass.setEnabled(false);
        contrasena.setEnabled(false);
        presenter.actContrasena(cortarCadena(action));

    }


    public String cortarCadena(String cadena){

        int posicion = cadena.lastIndexOf("/");
        cadena = cadena.substring(posicion+1);
        return cadena;
    }

    @Override
    public void mostrarPantallaInicio(String mensaje) {

    }

    @Override
    public void mostrarError(String error) {

    }

    @Override
    public void activaCampos(UsuarioDTO usuario) {

        nuevopass.setEnabled(true);
        contrasena.setEnabled(true);
        nuevopass.requestFocus();
        Log.d(TAG, "activaCampos: el usuario es: " + usuario.usuario.usuario);
    }
}
