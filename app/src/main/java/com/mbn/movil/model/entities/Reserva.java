package com.mbn.movil.model.entities;

import java.util.Date;

/**
 * Created by lenovo on 14/07/2017.
 */

public class Reserva {
    public Integer reservaId;
    public Date fechaInicio;
    public Date fechaFin;
    public String estado;
    public Habitacion habitacionId;
    public Usuario usuarioId;
}
