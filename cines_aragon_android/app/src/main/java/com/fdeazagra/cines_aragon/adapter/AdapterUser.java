package com.fdeazagra.cines_aragon.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.model.Constantes;
import com.fdeazagra.cines_aragon.model.Ticket;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterUser extends  RecyclerView.Adapter<AdapterUser.UserViewHolder> {

    ArrayList<Ticket> tickets;

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        public ImageView imagen;
        public TextView nombre;
        public TextView cine;
        public TextView fecha;
        public TextView pelicula;

        public UserViewHolder(@NonNull View v) {
            super(v);

            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            cine = (TextView) v.findViewById(R.id.cine);
            fecha = (TextView) v.findViewById(R.id.fecha);
            pelicula = (TextView) v.findViewById(R.id.pelicula);

        }
    }

    public AdapterUser(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tickets_row, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder viewHolder, int posFila) {

        String urlImage = Constantes.IMAGES +
                tickets.get(posFila).getUrl_imagen() + ".png";
        Picasso.get().load(urlImage).into(viewHolder.imagen);

        viewHolder.nombre.setText(tickets.get(posFila).getUsuario());
        viewHolder.cine.setText("Cine: " + tickets.get(posFila).getCine());
        viewHolder.fecha.setText("Fecha: " + tickets.get(posFila).getFecha());
        viewHolder.pelicula.setText(tickets.get(posFila).getPelicula());
    }

    @Override
    public int getItemCount() {return tickets.size();}

}
