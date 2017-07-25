package com.mbn.movil.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
import butterknife.OnClick;

public class ActualizarContrasenaActivity extends BaseActivity implements ActContrasenaContract.Vista {

    public static final String TAG = ActualizarContrasenaActivity.class.getSimpleName();
    public static UsuarioDTO usuarioEnvio;

    @BindView(R.id.nuevoPass)
    EditText nuevopass;

    @BindView(R.id.contrasena)
    EditText contrasena;

    @BindView(R.id.btnActPass)
    Button btnActPass;

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
        btnActPass.setEnabled(false);
        presenter.actContrasena(cortarCadena(action));

    }

    @OnClick(R.id.btnActPass)
    public void cambiarContrasena(View btn) {
        if((nuevopass.getText().toString() != null & nuevopass.getText().toString().length() >0) &&
                (contrasena.getText().toString() !=null & contrasena.getText().toString().length() >0)){
            if(nuevopass.getText().toString().equals(contrasena.getText().toString())){
                    usuarioEnvio.usuario.contrasena = nuevopass.getText().toString();
                    presenter.enviarUsuario(usuarioEnvio);
            }else{
                Toast.makeText(this, R.string.contrasena_no_coincide, Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, R.string.rellenar_campos, Toast.LENGTH_LONG).show();
        }
    }

    public String cortarCadena(String cadena){

        int posicion = cadena.lastIndexOf("/");
        cadena = cadena.substring(posicion+1);
        return cadena;
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarPantallaInicio(String mensaje) {
        Log.d(TAG, "mostrarPantallaInicio: Paso por aqui");
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void activaCampos(UsuarioDTO usuario) {
        nuevopass.setEnabled(true);
        contrasena.setEnabled(true);
        btnActPass.setEnabled(true);
        nuevopass.requestFocus();
        usuarioEnvio = usuario;
    }

}
