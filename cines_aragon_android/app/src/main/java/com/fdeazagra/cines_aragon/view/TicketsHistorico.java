package com.fdeazagra.cines_aragon.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.adapter.AdapterPelicula;
import com.fdeazagra.cines_aragon.adapter.AdapterUser;
import com.fdeazagra.cines_aragon.login_user.LoginUserContract;
import com.fdeazagra.cines_aragon.login_user.LoginUserPresenter;
import com.fdeazagra.cines_aragon.model.Ticket;
import com.fdeazagra.cines_aragon.model.User;

import java.util.ArrayList;

public class TicketsHistorico extends AppCompatActivity
        implements LoginUserContract.View {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private LoginUserPresenter loginUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        String valor = getIntent().getStringExtra("valor");
        User user = new User();
        user.setNombre(valor);
        loginUserPresenter = new LoginUserPresenter(this);
        loginUserPresenter.getTickets(user);

        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

    }

    @Override
    public void successLogin(ArrayList<User> usuarios, ArrayList<Ticket> tickets) {

        adapter = new AdapterUser(tickets);
        recycler.setAdapter(adapter);
    }

    @Override
    public void failureLogin(String message) {

    }
}
