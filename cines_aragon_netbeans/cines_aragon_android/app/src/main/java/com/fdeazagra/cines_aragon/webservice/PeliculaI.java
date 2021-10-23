package com.fdeazagra.cines_aragon.webservice;

import com.fdeazagra.cines_aragon.model.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PeliculaI {

    @GET("peliculas")
    Call<List<Pelicula>> getPeliculas();

    @POST("peliculas/genero")
    Call<List<Pelicula>> getByGenero(@Body Pelicula pelicula);

    @POST("peliculas/titulo")
    Call<List<Pelicula>> getByTitulo(@Body Pelicula pelicula);
}
