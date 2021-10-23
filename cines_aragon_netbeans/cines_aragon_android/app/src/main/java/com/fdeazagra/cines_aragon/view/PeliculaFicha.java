package com.fdeazagra.cines_aragon.view;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.buscar_Pelicula.BuscarPeliculaContract;
import com.fdeazagra.cines_aragon.buscar_Pelicula.BuscarPeliculaPresenter;
import com.fdeazagra.cines_aragon.model.Constantes;
import com.fdeazagra.cines_aragon.model.Pelicula;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PeliculaFicha extends AppCompatActivity
        implements BuscarPeliculaContract.View {

    public ImageView imagen;
    public TextView titulo;
    public TextView genero;
    public TextView ficha;
    public TextView cine;
    private Button btnCompra;
    private Button btnTrailer;
    private BuscarPeliculaPresenter buscarPeliculaPresenter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha_pelicula);

        /*Instanciar Presenter*/
        String valor = getIntent().getStringExtra("valor");
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(valor);
        buscarPeliculaPresenter = new BuscarPeliculaPresenter(this);
        buscarPeliculaPresenter.getFicha(pelicula);

        initComponents();

        /*Accion al pulsar el boton Compra*/
        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*Accion al pulsar el boton Trailer*/
        btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /*Declaramos objetos del layout*/
    private void initComponents(){

        imagen = (ImageView) findViewById(R.id.imagen);
        titulo = (TextView) findViewById(R.id.titulo);
        genero = (TextView) findViewById(R.id.genero);
        ficha = (TextView) findViewById(R.id.ficha);
        cine = (TextView) findViewById(R.id.cine);
        btnCompra = (Button) findViewById(R.id.btnCompra);
        btnTrailer = (Button) findViewById(R.id.btnTrailer);
    }

    @Override
    public void successBuscarPeliculas(ArrayList<Pelicula> lstPeliculas) {

        /*for (Pelicula pelicula: lstPeliculas){
            String urlImage = Constantes.IMAGES +
                    pelicula.getUrl_imagen() + ".png";
            Picasso.get().load(urlImage).into(imagen);

            titulo.setText(pelicula.getTitulo());
            genero.setText(pelicula.getGenero());
            ficha.setText(pelicula.getFicha());
            cine.setText("Cine: " + pelicula.getCine_id()
                    + " pases: " + pelicula.getPases());
        }
        */
    }

    @Override
    public void failureBuscarPeliculas(String message) {

    }
}


