package com.mbn.movil.view.impl;

import android.app.ProgressDialog;
import android.content.Context;

import com.mbn.movil.R;

/**
 * Created by annelkaren on 14/07/17.
 */

public class ProgresoModal extends ProgressDialog {

    public ProgresoModal(Context context, int max) {
        super(context);
        setMax(max);
        setMessage(context.getString(R.string.cargando));
        setTitle(context.getString(R.string.procesando));
    }

}
