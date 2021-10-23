package com.fdeazagra.cines_aragon.model;

import java.io.Serializable;

/**
 * Clase de la entidad Cine
 *
 * @author Fernando Martínez de Azagra Detraux.
 */
public class Cine {

    private int id;
    private String nombre;
    private String provincia;
    private String pases;
    private String telefono;
    private String ciudad;
    private String pelicula_id;
    private String url_imagen;


    /**
     * Constructor mínimo.
     */
    public Cine() {
    }

    /**
     * Constructor parametrizado.
     *
     * @param id          Número de identificación único Primary key.
     * @param nombre      Nombre del cine.
     * @param provincia   Provincia donde se encuentra el cine.
     * @param pases       Horario de pases de la película del cine.
     * @param telefono    Número de teléfono del cine.
     * @param ciudad   Número id de la ciudad donde se encuentra el cine.
     * @param pelicula_id Número id de la pelicula en cartel.
     * @param url_imagen Url con la imagen de la película.
     */
    public Cine(int id, String nombre, String provincia, String pases,
                String telefono, String ciudad, String pelicula_id, String url_imagen) {

        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.pases = pases;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pelicula_id = pelicula_id;
        this.url_imagen = url_imagen;
    }


    /**
     * Getters & Setters.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPases() {
        return pases;
    }

    public void setPases(String pases) {
        this.pases = pases;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad_id(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(String pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }


}


