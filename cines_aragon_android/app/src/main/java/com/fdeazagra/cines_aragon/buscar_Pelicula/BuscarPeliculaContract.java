package com.fdeazagra.cines_aragon.buscar_Pelicula;


import com.fdeazagra.cines_aragon.model.Pelicula;

import java.util.ArrayList;

/**
 * Interface para implementar el patrón MVP y definir sus métodos.
 *
 * @author Fernando Martínez de Azagra Detraux
 */
public interface BuscarPeliculaContract {

    public interface View {
        void successBuscarPeliculas(ArrayList<Pelicula> lstPeliculas);
        void failureBuscarPeliculas(String message);

    }
    public interface Presenter {
        void getPeliculas();
        void getByGenero(Pelicula pelicula);
        void getFicha(Pelicula pelicula);
    }
    public interface Model {

        interface OnBuscarPeliculaListener {
            void onFinished(ArrayList<Pelicula> lstPeliculas);
            void onFailure(String error);
        }
            void getPeliculaFindAll(OnBuscarPeliculaListener onBuscarPeliculaListener);
            void getPeliculaByGenero(OnBuscarPeliculaListener onBuscarPeliculaListener, Pelicula pelicula);
            void getPeliculaByTitulo(OnBuscarPeliculaListener onBuscarPeliculaListener, Pelicula pelicula);

    }
}
