package com.mbn.movil.presenter;

import com.mbn.movil.model.dto.EdificioDTO;

/**
 * Created by lenovo on 12/07/2017.
 */

public interface ObtenerEdificiosContract {

        interface Vista {
            void mostrarPantallaEdificios();
            void mostrarError();
        }

        interface Presenter {
            void ObtenerEdificios();


            //Callbacks
            void exitoObtenerEdificos(EdificioDTO dto);
            void errorObtenerEdificos(EdificioDTO dto);
            void errorObtenerEdificos(String texto);
        }

}
