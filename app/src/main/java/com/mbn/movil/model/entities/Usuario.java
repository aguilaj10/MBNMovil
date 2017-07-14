package com.mbn.movil.model.entities;

/**
 * Created by jonathan on 11/07/17.
 */

public class Usuario {
    public String usuario;
    public String contrasena;
    public String nombre;
    public String apellidos;
    public boolean checked;

    @Override
    public String toString() {
        return nombre+" "+apellidos;
    }

    public String estado;
    public Integer usuarioId;

}
