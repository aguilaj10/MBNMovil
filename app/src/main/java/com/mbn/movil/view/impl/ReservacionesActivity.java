package com.mbn.movil.view.impl;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.mbn.movil.R;
import com.mbn.movil.di.DaggerReservasComponent;
import com.mbn.movil.di.ModuloComun;
import com.mbn.movil.di.ModuloReservas;
import com.mbn.movil.model.dto.EdificioDTO;
import com.mbn.movil.model.dto.HabitacionDTO;
import com.mbn.movil.model.entities.Edificio;
import com.mbn.movil.model.entities.Habitacion;
import com.mbn.movil.presenter.ReservacionesContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.appcompat.R.styleable.View;

public class ReservacionesActivity extends AppCompatActivity implements ReservacionesContract.Vista {
    @BindView(R.id.spinner)
    Spinner spinner ;
    @BindView(R.id.txtFechaInicio)
    TextView fechaInicio;
    @BindView(R.id.txtFechaFin)
    TextView fechaFin;
    @BindView(R.id.spinner2)
    Spinner habitaciones;

    @Inject
    ReservacionesContract.Presenter presenter;

    private Edificio edif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservaciones);


        ButterKnife.bind(this);

        DaggerReservasComponent.builder()
                .moduloComun(new ModuloComun(getApplication()))
                .moduloReservas(new ModuloReservas(this))
                .build().inyectarEnReservacionesActivity(this);


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


        presenter.obtenerEdificios();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                edif = (Edificio) parent.getAdapter().getItem(position);
                obtenerHabitaciones();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fechaInicio.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    obtenerHabitaciones();
                }
            }
        });

        fechaFin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    obtenerHabitaciones();
                }
            }
        });
    }

    private void obtenerHabitaciones() {
        if(edif != null && !fechaInicio.getText().toString().equalsIgnoreCase("") & !fechaFin.getText().toString().equalsIgnoreCase("")) {
            presenter.obtenerHabitaiones(edif, fechaInicio.getText().toString(), fechaFin.getText().toString());
        }
    }

    @Override
    public void mostrarPantallaReservas() {

    }

    @Override
    public void mostrarError() {

    }

    @Override
    public void llenarListaEdificios(EdificioDTO dto) {
        ArrayAdapter<Edificio> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dto.edificios);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void llenarListaHabitaciones(HabitacionDTO dto) {
        ArrayAdapter<Habitacion> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dto.habitaciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        habitaciones.setAdapter(adapter);
    }
}
