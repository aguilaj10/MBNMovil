package com.mbn.movil.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mbn.movil.MBNMovilApp;

import com.mbn.movil.R;

public class HomeActivity extends AppCompatActivity {
    public static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
//        setTitle(getTitle() + " " + MBNMovilApp.dto.usuario.nombre);
    }

    @OnClick (R.id.imageButtonReservaciones)
    public void mostrarLayoutReservaciones(View btn) {
        Log.d(TAG, "Mostrar pantalla para reservaciones.");
        Intent intentoMostrarReservaciones = new Intent(this,ReservacionesActivity.class);
        startActivity(intentoMostrarReservaciones);
    }

    @OnClick (R.id.imageButtonViajes)
    public  void  mostrarLayoutViajes(){
        Log.d(TAG, "Mostrar pantalla viajes.");
        Intent intentoMostrarViajes = new Intent(this,ViajesActivity.class);
        startActivity(intentoMostrarViajes);

    }
}
