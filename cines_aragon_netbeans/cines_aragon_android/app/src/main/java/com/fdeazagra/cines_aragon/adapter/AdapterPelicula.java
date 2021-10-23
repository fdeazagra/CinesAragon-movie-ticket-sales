package com.fdeazagra.cines_aragon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.model.Constantes;
import com.fdeazagra.cines_aragon.model.Pelicula;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPelicula extends RecyclerView.Adapter<AdapterPelicula.PeliculaViewHolder>  {

    ArrayList<Pelicula> lstPeliculas;

    public static class PeliculaViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView titulo;
        public TextView genero;
        public TextView ficha;
        public TextView cine;


        public PeliculaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            titulo = (TextView) v.findViewById(R.id.titulo);
            genero = (TextView) v.findViewById(R.id.genero);
            ficha = (TextView) v.findViewById(R.id.ficha);
            cine = (TextView) v.findViewById(R.id.cine);

        }
    }

    public AdapterPelicula(ArrayList<Pelicula> lstPeliculas) {
        this.lstPeliculas = lstPeliculas;
    }

    @Override
    public PeliculaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.film_row, viewGroup, false);
        return new PeliculaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PeliculaViewHolder viewHolder, int posFila) {

        String urlImage = Constantes.IMAGES +
                lstPeliculas.get(posFila).getUrl_imagen() + ".png";
        Picasso.get().load(urlImage).into(viewHolder.imagen);

        viewHolder.titulo.setText(lstPeliculas.get(posFila).getTitulo());
        viewHolder.ficha.setText(lstPeliculas.get(posFila).getFicha());
        viewHolder.genero.setText(lstPeliculas.get(posFila).getGenero());
        viewHolder.cine.setText("Cine: " + lstPeliculas.get(posFila).getCine_id());
    }

    @Override
    public int getItemCount() {
        return lstPeliculas.size();
    }

}
