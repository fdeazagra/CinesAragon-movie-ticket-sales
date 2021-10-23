package com.fdeazagra.cines_aragon.buscar_Pelicula;

import com.fdeazagra.cines_aragon.model.Constantes;
import com.fdeazagra.cines_aragon.model.Pelicula;
import com.fdeazagra.cines_aragon.webservice.PeliculaI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscarPeliculaModel implements BuscarPeliculaContract.Model {

    private OnBuscarPeliculaListener onBuscarPeliculaListener;

    @Override
    public void getPeliculaFindAll(final OnBuscarPeliculaListener onBuscarPeliculaListener) {
        this.onBuscarPeliculaListener = onBuscarPeliculaListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PeliculaI peliculaI = retrofit.create(PeliculaI.class);
        Call<List<Pelicula>> call = peliculaI.getPeliculas();

        call.enqueue(new Callback<List<Pelicula>>() {
            @Override
            public void onResponse(Call<List<Pelicula>> call,
                                   Response<List<Pelicula>> response) {

                    List<Pelicula> lstPeliculas = response.body();
                    onBuscarPeliculaListener.onFinished((ArrayList<Pelicula>) lstPeliculas);

            }

            @Override
            public void onFailure(Call<List<Pelicula>> call,
                                  Throwable t) {
                onBuscarPeliculaListener.onFailure("Fallo: Listar Películas");
            }
        });

    }

    @Override
    public void getPeliculaByGenero(OnBuscarPeliculaListener onBuscarPeliculaListener, Pelicula pelicula) {

        this.onBuscarPeliculaListener = onBuscarPeliculaListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PeliculaI peliculaI = retrofit.create(PeliculaI.class);
        Call<List<Pelicula>> call = peliculaI.getByGenero(pelicula);

        call.enqueue(new Callback<List<Pelicula>>() {
            @Override
            public void onResponse(Call<List<Pelicula>> call,
                                   Response<List<Pelicula>> response) {

                List<Pelicula> lstPeliculas = response.body();
                onBuscarPeliculaListener.onFinished((ArrayList<Pelicula>) lstPeliculas);
            }

            @Override
            public void onFailure(Call<List<Pelicula>> call, Throwable t) {

                onBuscarPeliculaListener.onFailure("Fallo: Listar Películas");
            }
        });
    }

    @Override
    public void getPeliculaByTitulo(OnBuscarPeliculaListener onBuscarPeliculaListener, Pelicula pelicula) {

        this.onBuscarPeliculaListener = onBuscarPeliculaListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PeliculaI peliculaI = retrofit.create(PeliculaI.class);
        Call<List<Pelicula>> call = peliculaI.getByTitulo(pelicula);

        call.enqueue(new Callback<List<Pelicula>>() {
            @Override
            public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {

                List<Pelicula> lstPeliculas = response.body();
                onBuscarPeliculaListener.onFinished((ArrayList<Pelicula>) lstPeliculas);
            }

            @Override
            public void onFailure(Call<List<Pelicula>> call, Throwable t) {

                onBuscarPeliculaListener.onFailure("Fallo: Ficha Película");

            }
        });

            }

}
