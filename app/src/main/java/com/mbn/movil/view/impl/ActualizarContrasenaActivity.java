package com.mbn.movil.view.impl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mbn.movil.R;

public class ActualizarContrasenaActivity extends AppCompatActivity {

    public static final String TAG = ActualizarContrasenaActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contrasena);
        Intent data = getIntent();
        String action = data.getData().getPath();

        Log.d(TAG, "onCreate: url = " + action);
    }
}
