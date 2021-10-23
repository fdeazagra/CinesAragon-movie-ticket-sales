package com.fdeazagra.cines_aragon.adapter;

import android.view.View;

import com.fdeazagra.cines_aragon.model.User;

public class AdapterUser {

    private User usuario;
    private View.OnClickListener listener;

    public AdapterUser(User usuario) {
        this.usuario = usuario;
    }
}
