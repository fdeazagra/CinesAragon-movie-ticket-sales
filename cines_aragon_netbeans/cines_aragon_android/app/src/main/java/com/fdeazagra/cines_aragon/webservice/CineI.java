package com.fdeazagra.cines_aragon.webservice;

import com.fdeazagra.cines_aragon.model.Cine;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CineI {

    @POST("cine/provincia")
    Call<List<Cine>> getCines(@Body Cine cine);

    @POST("cine/nombre")
    Call<List<Cine>> getByNombre(@Body Cine cine);

}
