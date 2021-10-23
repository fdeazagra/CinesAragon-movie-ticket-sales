package com.fdeazagra.cines_aragon.webservice;

import com.fdeazagra.cines_aragon.model.Ticket;
import com.fdeazagra.cines_aragon.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserI {

    @POST("user/login")
    Call<List<User>> getLogin(@Body User user);

    @POST("user/tickets")
    Call<List<Ticket>> getTickets(@Body User user);
}
