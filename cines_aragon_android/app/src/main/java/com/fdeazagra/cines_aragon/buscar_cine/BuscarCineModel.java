package com.fdeazagra.cines_aragon.buscar_cine;

import com.fdeazagra.cines_aragon.model.Cine;
import com.fdeazagra.cines_aragon.model.Constantes;
import com.fdeazagra.cines_aragon.model.Pelicula;
import com.fdeazagra.cines_aragon.webservice.CineI;
import com.fdeazagra.cines_aragon.webservice.PeliculaI;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscarCineModel implements BuscarCineContract.Model {

    private OnBuscarCineListener onBuscarCineListener;

    @Override
    public void getCineByProvincia(OnBuscarCineListener onBuscarCineListener, Cine cine) {

        this.onBuscarCineListener = onBuscarCineListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CineI cineI = retrofit.create(CineI.class);
        Call<List<Cine>> call = cineI.getCines(cine);

        call.enqueue(new Callback<List<Cine>>() {
            @Override
            public void onResponse(Call<List<Cine>> call, Response<List<Cine>> response) {

                List<Cine> lstCines = response.body();

                onBuscarCineListener.onFinished((ArrayList<Cine>) lstCines);
            }

            @Override
            public void onFailure(Call<List<Cine>> call, Throwable t) {

                onBuscarCineListener.onFailure("Fallo: Buscar Cines");
            }
        });

    }

    @Override
    public void getCineByNombre(OnBuscarCineListener onBuscarCineListener, Cine cine) {

        this.onBuscarCineListener = onBuscarCineListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CineI cineI = retrofit.create(CineI.class);
        Call<List<Cine>> call = cineI.getByNombre(cine);

        call.enqueue(new Callback<List<Cine>>() {
            @Override
            public void onResponse(Call<List<Cine>> call, Response<List<Cine>> response) {

                List<Cine> lstCines = response.body();

                onBuscarCineListener.onFinished((ArrayList<Cine>) lstCines);
            }

            @Override
            public void onFailure(Call<List<Cine>> call, Throwable t) {

                onBuscarCineListener.onFailure("Fallo: Buscar Cines");
            }
        });
    }


}