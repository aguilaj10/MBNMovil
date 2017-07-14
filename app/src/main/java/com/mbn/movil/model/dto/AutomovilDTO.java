package com.mbn.movil.model.dto;

import com.mbn.movil.model.entities.Automovil;
import com.mbn.movil.model.entities.Usuario;

import java.util.List;

/**
 * Created by MBN USER on 12/07/2017.
 */

public class AutomovilDTO extends GenericDTO {
    public Automovil automovil;
    public String fotoAutomovil;
    public List<Usuario> conductores;
}
