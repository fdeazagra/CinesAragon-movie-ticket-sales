package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;


/**
 * Clase de la entidad Film
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class Film {
    
    private int id;
    private String titulo, ficha, genero, trailer, url_imagen, cine_id, pases;

    /**
     * Constructor parametrizado.
     * 
     * @param titulo Nombre de la película.
     * @param ficha Ficha con los datos de la película.
     * @param genero Género de la película: drama, comedia, acción....
     * @param trailer URL con el trailer de la película.
     * @param url_imagen URL donde se encuentra la imagen de la película.
     * @param id Número de identificación único Primary key.
     * @param cine_id Número de identificación del cine.
     * @param pases Pases en los que se proyecta la película.

     */
    public Film(int id, String titulo, String ficha, String genero, 
            String trailer, String url_imagen, String cine_id, String pases ) {
        
        this.id = id;
        this.titulo = titulo;
        this.ficha = ficha;
        this.genero = genero;
        this.trailer = trailer;
        this.url_imagen = url_imagen;
        this.cine_id = cine_id;
        this.pases = pases;
        
    }

    /**
     * Constructor mínimo.
     */
    public Film() {
    }

    /**
     * Getters & Setters.
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPases() {
        return pases;
    }

    public void setPases(String pases) {
        this.pases = pases;
    }
    
    
    
    /**
     * Método toString de Film.
     * 
     * @return Todos los atributos de la entidad concatenados en un String.
     */
    @Override    
    public String toString() {
        return "Film{" + "id=" + id
                + ", titulo=" + titulo + ", ficha="
                + ficha + ", genero=" + genero
                + ", trailer=" + trailer + ", url_imagen="
                + url_imagen + ", cine_id="+ cine_id
                + ", pases=" + pases
                + '}';
    }

    /**
     * Método para pasar un objeto Film a un String en formato Json.
     * 
     * @return String de Film en Json.
     */
    public static String toCadena(Film pelicula) {
        return "{" 
                + "id=" + pelicula.getId() + ", "
                + "título=" + pelicula.getTitulo() + ", "
                + "ficha=" + pelicula.getFicha() + ", "
                + "género=" + pelicula.getGenero() + ", "
                + "trailer=" + pelicula.getTrailer() + ", "
                + "cine_id=" + pelicula.getCine_id()+ ", "
                + "URL_imagen=" + pelicula.getUrl_imagen()
                + "}";
    }
    
    /**
     * Método que devuelve en String un array de Film en formato Json .
     * 
     * @return resp.
     */
    public static String toArrayJSon(ArrayList<Film> peliculas) {
            
        GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(peliculas);
            
            return resp;
    }
    
    /**
     * Método para pasar un objeto Film a un String en formato Json.
     * 
     * @return String de Film en Json.
     */
    public static String toObjectJson(Film pelicula){
        
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(pelicula);
        return resp;
    }    
}
