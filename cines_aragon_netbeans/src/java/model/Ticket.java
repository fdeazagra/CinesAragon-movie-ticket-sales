package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 * Clase de la entidad Ticket
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class Ticket {
    
    private String fecha;
    private String cine;
    private String pelicula;
    private String usuario;
    private String url_imagen;

    public Ticket() {
    }

    /**
     * Constructor parametrizado.
     *

     * @param fecha Fecha de la compra del ticket.
     * @param cine Cine donde se vió la película.
     * @param pelicula Nombre de la película.
     * @param usuario Usuario al que pertenece el ticket.
     * @param url_imagen Url donde se aloja la imagen de la película.
     */
    public Ticket(String fecha, String cine, String pelicula, String usuario, String url_imagen) {
        this.fecha = fecha;
        this.cine = cine;
        this.pelicula = pelicula;
        this.usuario = usuario;
        this.url_imagen = url_imagen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCine() {
        return cine;
    }

    public void setCine(String cine) {
        this.cine = cine;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
    
    

    /**
     * Método toString de Ticket.
     * 
     * @return Todos los atributos de la entidad concatenados en un String.
     */
    @Override
    public String toString() {
            
            return "Ticket{" 
                    + "fecha=" + fecha 
                    + ", cine=" + cine 
                    + ", pelicula=" + pelicula 
                    + ", usuario=" + usuario 
                    + ", url_imagen=" + url_imagen 
                    + '}';
    }

    /**
     * Método que devuelve en String un array de Ticket en formato Json .
     * 
     * @return resp.
     */
    public static String toArrayJSon(ArrayList<Ticket> tickets) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        
        Gson gson = builder.create();
        String resp = gson.toJson(tickets);
        
        return resp;
    }
}
