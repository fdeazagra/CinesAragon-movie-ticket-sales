package com.fdeazagra.cines_aragon.login_user;


import com.fdeazagra.cines_aragon.model.User;

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
            public void onFinished(User usuario) {
                vista.successLogin(usuario);
            }

            @Override
            public void onFailure(String error) {
                vista.failureLogin(error);
            }
        }, usuario);
    }

}
