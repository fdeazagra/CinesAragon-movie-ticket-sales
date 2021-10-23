package com.fdeazagra.cines_aragon.buscar_Pelicula;

import com.fdeazagra.cines_aragon.model.Pelicula;

import java.util.ArrayList;

public class BuscarPeliculaPresenter implements BuscarPeliculaContract.Presenter {

    private BuscarPeliculaContract.View vista;
    private BuscarPeliculaModel modelo;


    public BuscarPeliculaPresenter(BuscarPeliculaContract.View vista) {
        this.vista = vista;
        this.modelo = new BuscarPeliculaModel();
    }

    @Override
    public void getPeliculas() {
        this.modelo.getPeliculaFindAll(new BuscarPeliculaContract.Model.OnBuscarPeliculaListener() {
            @Override
            public void onFinished(ArrayList<Pelicula> lstPeliculas) {
                vista.successBuscarPeliculas(lstPeliculas);

            }

            @Override
            public void onFailure(String error) {

            }
        });

    }

    @Override
    public void getByGenero(Pelicula pelicula) {

        this.modelo.getPeliculaByGenero(new BuscarPeliculaContract.Model.OnBuscarPeliculaListener() {
            @Override
            public void onFinished(ArrayList<Pelicula> lstPeliculas) {
                vista.successBuscarPeliculas(lstPeliculas);
            }

            @Override
            public void onFailure(String error) {

            }
        }, pelicula);

    }

    @Override
    public void getFicha(Pelicula pelicula) {

        this.modelo.getPeliculaByTitulo(new BuscarPeliculaContract.Model.OnBuscarPeliculaListener() {
            @Override
            public void onFinished(ArrayList<Pelicula> lstPeliculas) {
                vista.successBuscarPeliculas(lstPeliculas);
            }

            @Override
            public void onFailure(String error) {

            }
        }, pelicula);
    }
}
