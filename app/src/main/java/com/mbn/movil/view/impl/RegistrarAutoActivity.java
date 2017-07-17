package com.mbn.movil.view.impl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mbn.movil.MBNMovilApp;
import com.mbn.movil.R;
import com.mbn.movil.di.DaggerViajesComponent;
import com.mbn.movil.di.ModuloComun;
import com.mbn.movil.di.ModuloViajes;
import com.mbn.movil.model.dto.AutomovilDTO;
import com.mbn.movil.model.dto.UsuarioDTO;
import com.mbn.movil.model.entities.Automovil;
import com.mbn.movil.model.entities.Usuario;
import com.mbn.movil.presenter.RegistrarAutomovilContract;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrarAutoActivity extends BaseActivity implements RegistrarAutomovilContract.Vista{
    private static final String TAG = RegistrarAutoActivity.class.getSimpleName();
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private String fotoAutomovil="";
    private List<Usuario> conductores=new ArrayList<>();
    private AutomovilDTO automovilDTO = new AutomovilDTO();

    @BindView(R.id.txtCapacidad)
    EditText txtCapacidad;

    @BindView(R.id.txtPlacas)
    EditText txtPlacas;

    @BindView(R.id.txtDescripcion)
    EditText txtDescripcion;

    @BindView(R.id.listaConductores)
    ListView listaConductores;

    @BindView(R.id.imgFotoAuto)
    ImageView imgFotoAuto;

    @Inject
    RegistrarAutomovilContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_auto);

        ButterKnife.bind(this);

        DaggerViajesComponent.builder()
                .moduloComun(new ModuloComun(getApplication()))
                .moduloViajes(new ModuloViajes(this))
                .build().inyectaEnRegistrarAutoActivity(this);

        presenter.buscarConductores(MBNMovilApp.dto);
    }

    @OnClick(R.id.btnCapturarFoto)
    public void capturarFotografia(){
        Log.d(TAG, "Capturando foto ============>");
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgFotoAuto.setImageBitmap(imageBitmap);
            fotoAutomovil = encodeImage(imageBitmap);
        }
    }

    private String encodeImage(Bitmap bm)    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encImage;
    }

    @OnClick(R.id.btnGuardar)
    public void guardarAutomovil(){

        Automovil automovil = new Automovil();
        automovil.capacidad=Integer.parseInt(txtCapacidad.getText().toString());
        automovil.placas = txtPlacas.getText().toString();
        automovil.descripcion = txtDescripcion.getText().toString();

        //Se agrega al usuario actual como conductor
        conductores.add(MBNMovilApp.dto.usuario);

        automovilDTO.automovil=automovil;
        automovilDTO.conductores=conductores;
        automovilDTO.fotoAutomovil=fotoAutomovil;

        presenter.guardarAutomovil(automovilDTO);
    }

    @Override
    public void mostrarExitoBuscarUsuarios(final List<Usuario> usuarios) {
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(
                        RegistrarAutoActivity.this,
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, usuarios);

        listaConductores.setAdapter(adapter);

        listaConductores.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuarioSeleccionado = usuarios.get(position);
                usuarioSeleccionado.checked = !usuarioSeleccionado.checked;
                if (usuarioSeleccionado.checked){
                    conductores.add(usuarioSeleccionado);
                }
            }
        });

    }

    @Override
    public void mostrarErrorBuscarUsuarios() {
        Toast.makeText(this, "Se ha producido un error buscando los conductores", Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarExitoGuardarAutomovil() {
        Toast.makeText(this, "Se ha guardado el automovil exitosamente!", Toast.LENGTH_LONG).show();;
    }

    @Override
    public void mostrarErrorGuardarAutomovil() {
        Toast.makeText(this, "Error guardando automovil!!", Toast.LENGTH_LONG).show();;
    }


}
