package com.fdeazagra.cines_aragon.login_user;

import com.fdeazagra.cines_aragon.model.Constantes;
import com.fdeazagra.cines_aragon.model.Ticket;
import com.fdeazagra.cines_aragon.model.User;
import com.fdeazagra.cines_aragon.webservice.UserI;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginUserModel implements LoginUserContract.Model {
    private ArrayList<User> lstUsers;
    private OnLoginUserListener onLoginUserListener;
    @Override
    public void getUserService(final OnLoginUserListener onLoginUserListener,
                               User usuario) {

        this.onLoginUserListener = onLoginUserListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserI userI = retrofit.create(UserI.class);
        Call<List<User>> call = userI.getLogin(usuario);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                List<User> lstUsuarios = response.body();
                List<Ticket> tickets = null;
                onLoginUserListener.onFinished((ArrayList<User>) lstUsuarios, (ArrayList<Ticket>) tickets);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                onLoginUserListener.onFailure("Fallo: Login");
            }
        });
    }

    @Override
    public void getTicketService(OnLoginUserListener onLoginUserListener,
                                 User usuario) {

        this.onLoginUserListener = onLoginUserListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserI userI = retrofit.create(UserI.class);
        Call<List<Ticket>> call = userI.getTickets(usuario);

        call.enqueue(new Callback<List<Ticket>>() {
            @Override
            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {

                List<Ticket> tickets = response.body();
                List<User> lstUsuarios = null;
                onLoginUserListener.onFinished((ArrayList<User>) lstUsuarios, (ArrayList<Ticket>) tickets);
            }

            @Override
            public void onFailure(Call<List<Ticket>> call, Throwable t) {

                onLoginUserListener.onFailure("Fallo: Tickets");
            }
        });
    }


}
