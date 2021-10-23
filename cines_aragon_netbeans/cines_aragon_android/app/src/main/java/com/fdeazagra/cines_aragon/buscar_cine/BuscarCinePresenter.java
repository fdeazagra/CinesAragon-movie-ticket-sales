package com.fdeazagra.cines_aragon.buscar_cine;

import android.widget.Toast;

import com.fdeazagra.cines_aragon.model.Cine;

import java.util.ArrayList;


public class BuscarCinePresenter implements BuscarCineContract.Presenter{

    private BuscarCineContract.View vista;
    private BuscarCineModel modelo;

    public BuscarCinePresenter(BuscarCineContract.View vista) {
        this.vista = vista;
        this.modelo = new BuscarCineModel();
    }

    @Override
    public void getByProvincia(Cine cine) {

        this.modelo.getCineByProvincia(new BuscarCineContract.Model.OnBuscarCineListener() {

            @Override
            public void onFinished(ArrayList<Cine> lstCines) {
                vista.successCines(lstCines);

            }

            @Override
            public void onFailure(String error) {

            }
        }, cine);
    }

    @Override
    public void getByNombre(Cine cine) {
        this.modelo.getCineByNombre(new BuscarCineContract.Model.OnBuscarCineListener() {
            @Override
            public void onFinished(ArrayList<Cine> lstCines) {
                vista.successCines(lstCines);
            }

            @Override
            public void onFailure(String error) {

            }
        }, cine);
    }
}
