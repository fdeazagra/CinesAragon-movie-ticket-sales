package com.fdeazagra.cines_aragon.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Clase de la entidad User
 *
 * @author Fernando Martínez de Azagra Detraux.
 */
public class User {
    private String email;
    private String password;
    private String nombre;

    /**
     * Constructor parametrizado.
     *
     * @param nombre Nombre del usuario.
     * @param email Email del usuario.
     * @param password Contraseña para acceder.
     */
    public User(String email, String password, String nombre) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
    }

    /**
     * Constructor mínimo.
     */
    public User() {
    }

    // GETTERS Y SETTERS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
