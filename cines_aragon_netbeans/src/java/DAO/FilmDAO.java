package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Film;
import utils.MotorMySQL;

/**
 * Clase con las consultas a la BBDD de la entidad Film.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class FilmDAO {
    
    private final String SQL_FINDALL
            = "SELECT film.* , cine.nombre, cine.pases "
            + "FROM film INNER JOIN cine "
            + "ON film.cine_id = cine.id "
            + "WHERE 1=1 ";
    private final String SQL_FIND_TITULOS
            = "SELECT titulo FROM `film` WHERE 1=1";
    
    private MotorMySQL motorSql;

    /**
     * Constructor que instancia un objeto de la clase MotorSQL
     * con los métodos de conexión a la BBDD.
     */
    public FilmDAO() {
        this.motorSql = new MotorMySQL();
    }

    /**
     * Busca en la BBDD todas las películas disponibles
     * y las devuelve con el cine donde se proyectan.
     * 
     * @param bean Film.
     * @return El listado de todas las ofertas.
     */
    public ArrayList<Film> findAll(Film bean) {
        ArrayList<Film> peliculas = new ArrayList<>();
        String sql= SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getId() != 0) {
                    sql += "AND id='" + bean.getId() + "'";
                }
                if (bean.getTitulo() != null) {
                    sql += "AND titulo='" + bean.getTitulo() + "'";
                }

                if (bean.getFicha() != null) {
                    sql += "AND ficha='" + bean.getFicha()+ "'";
                }
                if (bean.getGenero() != null) {
                    sql += "AND genero='" + bean.getGenero()+ "'";
                }

                if (bean.getTrailer() != null) {
                    sql += "AND trailer='" + bean.getTrailer()+ "'";
                }
                if (bean.getUrl_imagen() != null) {
                    sql += "AND url_imagen='" + bean.getUrl_imagen() + "'";
                }
                if (bean.getCine_id() != null) {
                    sql += "AND cine_id='" + bean.getCine_id()+ "'";
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Film pelicula = new Film();

                pelicula.setId(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setFicha(rs.getString(3));
                pelicula.setGenero(rs.getString(4));
                pelicula.setTrailer(rs.getString(5));
                pelicula.setUrl_imagen(rs.getString(6));
                pelicula.setCine_id(rs.getString(8));
                
                

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    /**
     * Busca en la BBDD todas las películas de un género.
     * 
     * @return El listado de todas las películas.
     */
    public ArrayList<Film> findByGenero(String genero) {
        ArrayList<Film> peliculas = new ArrayList<>();
       
        try {
            
            this.motorSql.connect();
            
            String sqlCabecera = SQL_FINDALL;
            String sqlFiltro = "";
            
            if (genero!=null && !genero.equals("")) {
                sqlFiltro += "AND film.genero='"+genero+"'";
            }

            String sqlFinal = sqlCabecera + sqlFiltro;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            while (rs.next()) {
                Film pelicula = new Film();

                pelicula.setId(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setFicha(rs.getString(3));
                pelicula.setGenero(rs.getString(4));
                pelicula.setTrailer(rs.getString(5));
                pelicula.setUrl_imagen(rs.getString(6));
                pelicula.setCine_id(rs.getString(8));
                

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    /**
     * Busca en la BBDD las películas por título.
     */
    public ArrayList<Film> findByTitulo(String titulo) {
        ArrayList<Film> peliculas = new ArrayList<>();
       
        try {
            
            this.motorSql.connect();
            
            String sqlCabecera = SQL_FINDALL;
            String sqlFiltro = "";
            
            if (titulo!=null && !titulo.equals("")) {
                sqlFiltro += "AND film.titulo='"+titulo+"'";
            }

            String sqlFinal = sqlCabecera + sqlFiltro;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            while (rs.next()) {
                Film pelicula = new Film();

                pelicula.setId(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setFicha(rs.getString(3));
                pelicula.setGenero(rs.getString(4));
                pelicula.setTrailer(rs.getString(5));
                pelicula.setUrl_imagen(rs.getString(6));
                pelicula.setCine_id(rs.getString(8));
                pelicula.setPases(rs.getString(9));
                
                 peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
        /**
     * Busca en la BBDD todos los títulos de películas en cartel.
     */
    public ArrayList<Film> getTitulos() {
        
        ArrayList<Film> lstPeliculas = new ArrayList<>();
        
        try {
            this.motorSql.connect();
            
            String sqlFinal = SQL_FIND_TITULOS;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            rs.beforeFirst();
            while (rs.next()) { 
                
                Film film = new Film();
                
                film.setTitulo(rs.getString(1));
                
                lstPeliculas.add(film);
            }
            
   

        } catch (Exception ex) {
            
        }
        finally{
             this.motorSql.disconnect();
        }

        return lstPeliculas;
    }
    
    /**
     * Busca en la BBDD películas por id
     * y devuelve el título y la URL donde está alojada la imagen.
     */
    public Film findById(int id) {
        
        Film pelicula = new Film();
        
        String sql= "SELECT titulo, url_imagen FROM film WHERE id='"+id+"' ";
        try { 
            motorSql.connect();

            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                
                pelicula.setTitulo(rs.getString(1));
                pelicula.setUrl_imagen(rs.getString(2));

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return pelicula;
    }

}
