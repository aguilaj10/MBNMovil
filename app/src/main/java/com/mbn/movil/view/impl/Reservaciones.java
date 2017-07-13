package com.mbn.movil.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mbn.movil.R;

import java.util.ArrayList;
import java.util.List;

public class Reservaciones extends AppCompatActivity {
    private Spinner spinner ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservaciones);

        spinner = (Spinner) findViewById(R.id.spinner);
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
        spinner.setAdapter(adapter);
    }
}
