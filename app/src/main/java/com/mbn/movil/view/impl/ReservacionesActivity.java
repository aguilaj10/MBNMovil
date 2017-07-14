package com.mbn.movil.view.impl;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.mbn.movil.R;
import com.mbn.movil.di.DaggerReservasComponent;
import com.mbn.movil.di.ModuloComun;
import com.mbn.movil.di.ModuloReservas;
import com.mbn.movil.presenter.ReservacionesContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

import static android.support.v7.appcompat.R.styleable.View;

public class ReservacionesActivity extends AppCompatActivity implements ReservacionesContract.Vista {
    private Spinner spinner ;
    private TextView fechaInicio;

    @Inject
    ReservacionesContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservaciones);


        ButterKnife.bind(this);

        DaggerReservasComponent.builder()
                .moduloComun(new ModuloComun(getApplication()))
                .moduloReservas(new ModuloReservas(this))
                .build().inyectarEnReservacionesActivity(this);


       /* spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("RANJITH");
        list.add("ARUN");
        list.add("JEESMON");
        list.add("NISAM");
        list.add("SREEJITH");
        list.add("SANJAY");
        list.add("AKSHY");
        list.add("FIROZ");
        list.add("RAHUL");
        list.add("ARJUN");
        list.add("SAVIYO");
        list.add("VISHNU");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/


        fechaInicio = (EditText) findViewById(R.id.fechaInicio);
        fechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                        fechaInicio.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                }, mYear, mMonth, mDay);
                dialog.show();
            }
        });



    }


    @Override
    public void mostrarPantallaReservas() {

    }

    @Override
    public void mostrarError() {

    }
}
