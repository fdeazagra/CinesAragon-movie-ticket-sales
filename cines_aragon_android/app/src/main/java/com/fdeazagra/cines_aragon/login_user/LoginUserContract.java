package com.fdeazagra.cines_aragon.login_user;

import com.fdeazagra.cines_aragon.model.Ticket;
import com.fdeazagra.cines_aragon.model.User;

import java.util.ArrayList;

/**
 * Interface para implementar el patrón MVP y definir sus métodos.
 *
 * @author Fernando Martínez de Azagra Detraux
 */
public interface LoginUserContract {

    public interface View {
        void successLogin(ArrayList<User> usuarios, ArrayList<Ticket> tickets);
        void failureLogin(String message);
    }
    public interface Presenter {
        void getUser(User usuario);
        void getTickets(User usuario);
    }
    public interface Model {

        interface OnLoginUserListener {
            void onFinished(ArrayList<User> usuarios, ArrayList<Ticket> tickets);
            void onFailure(String error);
        }
        void getUserService(OnLoginUserListener onLoginUserListener,
                            User usuario);
        void getTicketService(OnLoginUserListener onLoginUserListener,
                              User usuario);
    }
}
