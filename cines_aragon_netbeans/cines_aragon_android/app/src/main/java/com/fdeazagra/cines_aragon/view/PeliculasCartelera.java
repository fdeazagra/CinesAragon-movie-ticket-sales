package com.fdeazagra.cines_aragon.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.adapter.AdapterPelicula;
import com.fdeazagra.cines_aragon.model.Pelicula;
import com.fdeazagra.cines_aragon.buscar_Pelicula.BuscarPeliculaContract;
import com.fdeazagra.cines_aragon.buscar_Pelicula.BuscarPeliculaPresenter;

import java.util.ArrayList;

public class PeliculasCartelera extends AppCompatActivity
        implements BuscarPeliculaContract.View {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private BuscarPeliculaPresenter buscarPeliculaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        // Instanciar el Presenter
        buscarPeliculaPresenter = new BuscarPeliculaPresenter(this);
        buscarPeliculaPresenter.getPeliculas();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

    }


    @Override
    public void successBuscarPeliculas(ArrayList<Pelicula> lstPeliculas) {

        // Creaar un nuevo adaptador
        adapter = new AdapterPelicula(lstPeliculas);
        recycler.setAdapter(adapter);
    }

    @Override
    public void failureBuscarPeliculas(String message) {

    }
}
