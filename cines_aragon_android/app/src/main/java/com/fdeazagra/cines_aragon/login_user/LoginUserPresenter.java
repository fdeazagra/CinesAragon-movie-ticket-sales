package com.fdeazagra.cines_aragon.login_user;


import com.fdeazagra.cines_aragon.model.Ticket;
import com.fdeazagra.cines_aragon.model.User;

import java.util.ArrayList;

public class LoginUserPresenter implements LoginUserContract.Presenter {

    private LoginUserContract.View vista;
    private LoginUserModel modelo;

    public LoginUserPresenter(LoginUserContract.View vista) {
        this.vista = vista;
        this.modelo = new LoginUserModel();
    }

    @Override
    public void getUser(User usuario) {

        modelo.getUserService(new LoginUserContract.Model.OnLoginUserListener() {
            @Override
            public void onFinished(ArrayList<User> usuarios, ArrayList<Ticket> tickets) {

                if (usuarios.size()!=0){
                    vista.successLogin(usuarios, null);
                } else{
                    vista.failureLogin("Usuario no encontrado");
                }
            }

            @Override
            public void onFailure(String error) {

                vista.failureLogin(error);
            }
        }, usuario);
    }

    @Override
    public void getTickets(User usuario) {

        modelo.getTicketService(new LoginUserContract.Model.OnLoginUserListener() {
            @Override
            public void onFinished(ArrayList<User> usuarios, ArrayList<Ticket> tickets) {

                vista.successLogin(null, tickets);
            }

            @Override
            public void onFailure(String error) {

                vista.failureLogin(error);
            }
        }, usuario);
    }


}
