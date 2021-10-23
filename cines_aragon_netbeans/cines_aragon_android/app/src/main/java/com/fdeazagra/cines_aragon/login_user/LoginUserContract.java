package com.fdeazagra.cines_aragon.login_user;

import com.fdeazagra.cines_aragon.model.User;

/**
 * Interface para implementar el patrón MVP y definir sus métodos.
 *
 * @author Fernando Martínez de Azagra Detraux
 */
public interface LoginUserContract {

    public interface View {
        void successLogin(User usuario);
        void failureLogin(String message);
    }
    public interface Presenter {
        void getUser(User usuario);
    }
    public interface Model {

        interface OnLoginUserListener {
            void onFinished(User usuario);
            void onFailure(String error);
        }
        void getUserService(OnLoginUserListener onLoginUserListener,
                            User usuario);
    }
}
