package com.fdeazagra.cines_aragon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.model.Cine;
import com.fdeazagra.cines_aragon.model.Constantes;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCine extends RecyclerView.Adapter<AdapterCine.CineViewHolder> {

    private ArrayList<Cine> lstCines;

    public static class CineViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView cine;
        public TextView pelicula;
        public TextView pases;
        public TextView provincia;
        public TextView ciudad;
        public TextView telefono;


        public CineViewHolder(View v) {
            super(v);

            imagen = (ImageView) v.findViewById(R.id.imagen);
            cine = (TextView) v.findViewById(R.id.cine);
            pelicula = (TextView) v.findViewById(R.id.pelicula);
            pases = (TextView) v.findViewById(R.id.pases);
            provincia = (TextView) v.findViewById(R.id.provincia);
            ciudad = (TextView) v.findViewById(R.id.ciudad);
            telefono = (TextView) v.findViewById(R.id.telefono);
        }
    }

    public AdapterCine (ArrayList<Cine> lstCines) {

        this.lstCines = lstCines;

    }

    @NonNull
    @Override
    public CineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_row_cines, parent, false);
        return new CineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CineViewHolder holder, int posFila) {

        String urlImage = Constantes.IMAGES +
                lstCines.get(posFila).getUrl_imagen() + ".png";
        Picasso.get().load(urlImage).into(holder.imagen);

        holder.cine.setText("Cine: " + lstCines.get(posFila).getNombre());
        holder.pelicula.setText(lstCines.get(posFila).getPelicula_id());
        holder.pases.setText("Pases: " + lstCines.get(posFila).getPases());
        holder.provincia.setText(lstCines.get(posFila).getProvincia());
        holder.ciudad.setText(lstCines.get(posFila).getCiudad());
        holder.telefono.setText(lstCines.get(posFila).getTelefono());
    }

    @Override
    public int getItemCount() {
        return lstCines.size();
    }

}
