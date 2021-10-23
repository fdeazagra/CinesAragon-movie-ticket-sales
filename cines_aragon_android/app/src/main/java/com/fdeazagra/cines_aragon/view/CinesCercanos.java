package com.fdeazagra.cines_aragon.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.adapter.AdapterCine;
import com.fdeazagra.cines_aragon.buscar_cine.BuscarCineContract;
import com.fdeazagra.cines_aragon.buscar_cine.BuscarCinePresenter;
import com.fdeazagra.cines_aragon.model.Cine;

import java.util.ArrayList;

public class CinesCercanos extends AppCompatActivity
        implements BuscarCineContract.View {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private BuscarCinePresenter buscarCinePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        // Instanciar el Presenter
        buscarCinePresenter = new BuscarCinePresenter(this);

        String valor = getIntent().getStringExtra("valor");
        String propiedad = getIntent().getStringExtra("propiedad");
        Cine cine = new Cine();
        if (propiedad.equals("provincia")) {

            cine.setProvincia(valor);
            buscarCinePresenter.getByProvincia(cine);
        }
        if (propiedad.equals("nombre")) {

            cine.setNombre(valor);
            buscarCinePresenter.getByNombre(cine);
        }



        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
    }

    @Override
    public void successCines(ArrayList<Cine> lstCines) {

        System.out.println("Adapter nº provincias: " + lstCines.size());
        // Creaar un nuevo adaptador
        adapter = new AdapterCine(lstCines);
        recycler.setAdapter(adapter);
    }

    @Override
    public void failureCines(String message) {

    }
}
