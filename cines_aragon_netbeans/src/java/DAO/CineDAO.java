
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MotorMySQL;
import model.Cine;

/**
 * Clase con las consultas a la BBDD de la entidad Cine.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class CineDAO {
    
    
private final String SQL_FIND_BY
        = "SELECT cine.nombre, cine.pases, cine.provincia, cine.ciudad,"
        + " cine.telefono, film.titulo, film.url_imagen "
        + "FROM cine INNER JOIN film "
        + "ON cine.pelicula_id = film.id "; 
    
    private MotorMySQL motorSql;
    
    /**
     * Constructor que instancia un objeto de la clase MotorSQL
     * con los métodos de conexión a la BBDD.
     */
    public CineDAO() {
        this.motorSql = new MotorMySQL();
    }
    
    /**
     * Busca en la BBDD los cines con el filtro de Nombre.
     * 
     * @return Las ofertas que pasan el filtro del destino.
     */
    public ArrayList<Cine> filtroNombre(String nombre) {
        
        ArrayList<Cine> lstCines = new ArrayList<>();
        
        try {
            this.motorSql.connect();
            
            String sqlCabecera = SQL_FIND_BY;
            String sqlFiltro = "";
            
            if (nombre!=null && !nombre.equals("")) {
                sqlFiltro += " WHERE cine.nombre='"+nombre+"'";
            }

            String sqlFinal = sqlCabecera + sqlFiltro;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            rs.beforeFirst();
            while (rs.next()) { 
                
                Cine cine = new Cine();
                
                cine.setNombre(rs.getString(1));
                cine.setProvincia(rs.getString(3));
                cine.setPases(rs.getString(2));
                cine.setTelefono(rs.getString(5));
                cine.setCiudad(rs.getString(4));                
                cine.setPelicula_id(rs.getString(6));
                cine.setUrl_imagen(rs.getString(7));
                
                lstCines.add(cine);
            }
            
   

        } catch (Exception ex) {
            
        }
        finally{
             this.motorSql.disconnect();
        }

        return lstCines;
    }

    
    /**
     * Busca en la BBDD los cines con el filtro de Provincia.
     * 
     * @param provincia La provincia marcada en el spinner.
     * @return Las ofertas que pasan el filtro del destino.
     */
    public ArrayList<Cine> filtroProvincia(String provincia) {
        
        ArrayList<Cine> lstCines = new ArrayList<>();
        
        try {
            this.motorSql.connect();
            
            String sqlCabecera = SQL_FIND_BY;
            String sqlFiltro = "";
            
            if (provincia!=null && !provincia.equals("")) {
                sqlFiltro += " WHERE cine.provincia='"+provincia+"'";
            }

            String sqlFinal = sqlCabecera + sqlFiltro;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            rs.beforeFirst();
            while (rs.next()) { 
                
                Cine cine = new Cine();
                
                cine.setNombre(rs.getString(1));
                cine.setProvincia(rs.getString(3));
                cine.setPases(rs.getString(2));
                cine.setTelefono(rs.getString(5));
                cine.setCiudad(rs.getString(4));                
                cine.setPelicula_id(rs.getString(6));
                cine.setUrl_imagen(rs.getString(7));
                
                lstCines.add(cine);
            }
            
   

        } catch (Exception ex) {
            
        }
        finally{
             this.motorSql.disconnect();
        }

        return lstCines;
    }

    
}
