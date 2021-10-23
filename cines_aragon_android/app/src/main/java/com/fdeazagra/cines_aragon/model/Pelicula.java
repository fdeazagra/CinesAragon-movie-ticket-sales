package com.fdeazagra.cines_aragon.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Clase de la entidad Pelicula
 *
 * @author Fernando Martínez de Azagra Detraux.
 */
public class Pelicula {

    private String titulo;
    private String ficha;
    private String genero;
    private String trailer;
    private String url_imagen;
    private String cine_id;
    private String pases;

    public Pelicula() {
    }

    /**
     * Constructor parametrizado.
     *
     * @param titulo Titulo de la película.
     * @param ficha Tipo de archivo: película, serie, documental.
     * @param trailer Puntuación de la película.
     * @param genero Género de la película: drama, comedia, acción....
     * @param url_imagen URL_IMAGEN donde se encuentra la película.
     * @param cine_id Cine donde se proyecta la película.
     * @param pases Pases en los que se proyecta la película.
     */
    public Pelicula(int imagen, String titulo, String ficha, String genero,
                    String trailer, String url_imagen, String cine_id, String pases) {

        this.titulo = titulo;
        this.ficha = ficha;
        this.genero = genero;
        this.trailer = trailer;
        this.url_imagen = url_imagen;
        this.cine_id = cine_id;
        this.pases = pases;

    }

    // GETTERS & SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String clase) {
        this.ficha = clase;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public String getCine_id() {
        return cine_id;
    }

    public void setCine_id(String cine_id) {
        this.cine_id = cine_id;
    }

    public String getPases() {
        return pases;
    }

    public void setPases(String pases) {
        this.pases = pases;
    }

}
