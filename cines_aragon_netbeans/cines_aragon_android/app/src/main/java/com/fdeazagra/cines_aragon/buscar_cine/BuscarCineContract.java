package com.fdeazagra.cines_aragon.buscar_cine;

import com.fdeazagra.cines_aragon.model.Cine;

import java.util.ArrayList;

/**
 * Interface para implementar el patrón MVP y definir sus métodos.
 *
 * @author Fernando Martínez de Azagra Detraux
 */
public interface BuscarCineContract {

    public interface View {
        void successCines(ArrayList<Cine> lstCines);
        void failureCines(String message);
    }
    public interface Presenter {
        void getByProvincia(Cine cine);
        void getByNombre(Cine cine);
    }
    public interface Model {

        interface OnBuscarCineListener {
            void onFinished(ArrayList<Cine> lstCines);
            void onFailure(String error);
        }
        void getCineByProvincia(OnBuscarCineListener onBuscarCineListener, Cine cine);
        void getCineByNombre(OnBuscarCineListener onBuscarCineListener, Cine cine);
    }
}
