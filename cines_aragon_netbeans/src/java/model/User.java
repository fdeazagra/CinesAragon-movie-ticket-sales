package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 * Clase de la entidad User
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class User {

    private int id;
    private String nombre;
    private String email;
    private String password;
    private int ciudad_id;
    private int ticket_id;

    /**
     * Constructor mínimo.
     */
    public User() {
    }

    /**
     * Constructor parametrizado.
     * 
     * @param id Número de identificación único Primary key.
     * @param nombre Nombre del usuario.
     * @param email Email del usuario.
     * @param password Contraseña para acceder.
     * @param ciudad_id Número de identificación de ciudad relacionada.
     * @param ticket_id Número de identificación de ticket relacionado.
     */
    public User(int id, String nombre, String email, String password,
            int ciudad_id, int ticket_id) {
        
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.ciudad_id = ciudad_id;
        this.ticket_id = ticket_id;
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

    public int getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(int ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }
    
    
    /**
     * Método toString de User.
     * 
     * @return Todos los atributos de la entidad concatenados en un String.
     */
    @Override
    public String toString() {
        
            return "User{" + "id=" + id + ", nombre=" + nombre + ", email=" +
                    email + ", password=" + password + ", ciudad_id=" + 
                    ciudad_id + ", ticket_id=" + ticket_id + '}';
    }

    /**
     * Método que devuelve en String un array de User en formato Json .
     * 
     * @return resp.
     */
    public static String toArrayJSon(ArrayList<User> usuarios) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        
        Gson gson = builder.create();
        String resp = gson.toJson(usuarios);
        
        return resp;
    }
}
