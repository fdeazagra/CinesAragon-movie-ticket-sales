
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cine;
import model.Ticket;
import utils.MotorMySQL;

/**
 * Clase con las consultas a la BBDD de la entidad Ticket.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class TicketDAO {
    
    private final String SQL_FIND_BY
        = "SELECT ticket.fecha, cine.nombre, film.titulo, user.nombre, film.url_imagen " + 
            "FROM ticket " +
            "INNER JOIN film ON ticket.pelicula_id = film.id " +
            "INNER JOIN cine ON ticket.cine_id = cine.id " +
            "INNER JOIN user ON ticket.user_id = user.id"; 
    
    private MotorMySQL motorSql;
    
        /**
     * Constructor que instancia un objeto de la clase MotorSQL
     * con los métodos de conexión a la BBDD.
     */
    public TicketDAO() {
        this.motorSql = new MotorMySQL();
    }
    
    /**
     * Busca en la BBDD los tickets con el filtro de Usuario.
     * 
     * @return Histórico de tickets comprados por el usuario .
     */
    public ArrayList<Ticket> getTickets(String nombre) {
        
        ArrayList<Ticket> lstTickets = new ArrayList<>();
        
        try {
            this.motorSql.connect();
            
            String sqlCabecera = SQL_FIND_BY;
            String sqlFiltro = "";
            
            if (nombre!=null && !nombre.equals("")) {
                sqlFiltro += " WHERE user.nombre='"+nombre+"'";
            }

            String sqlFinal = sqlCabecera + sqlFiltro;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            rs.beforeFirst();
            while (rs.next()) { 
                
                Ticket ticket = new Ticket();
                
                ticket.setFecha(rs.getString(1));
                ticket.setCine(rs.getString(2));
                ticket.setPelicula(rs.getString(3));
                ticket.setUsuario(rs.getString(4));                
                ticket.setUrl_imagen(rs.getString(5));
                
                lstTickets.add(ticket);
            }
            
   

        } catch (Exception ex) {
            
        }
        finally{
             this.motorSql.disconnect();
        }

        return lstTickets;
    }
    
}
