package com.mbn.movil.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mbn.movil.MBNMovilApp;
import com.mbn.movil.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle(getTitle() + " " + MBNMovilApp.dto.usuario.nombre);
    }
}
