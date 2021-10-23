package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase con los métodos necesarios para conectar y consultar con MySQL.
 * 
 * @author Fernando Martínez de Azagra Detraux
 */
public class MotorMySQL {

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    private static final String URL
            = "jdbc:mysql://localhost/cines_aragon";   
    private static final String CONTROLADOR
            = "com.mysql.jdbc.Driver";    
    private static final String USER = "root";
    private static final String PASS = "";
    
    /**
     * Método para conectar con la BBDD
     */
    public void connect() {
        
        try {
            
            Class.forName(CONTROLADOR);
            conn = DriverManager.
                    getConnection(URL, USER, PASS);
            st = conn.createStatement();
            System.out.println("conectado");
            
        } catch (ClassNotFoundException ex) {
            
            System.out.println(ex.getMessage());
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método para Consultas DDL - Data Definition Language.
     * 
     * @param sql Sentencia sql de algún método de los DAO.
     * @return INT de control de operación correcta.
     */
    public int execute(String sql) {
        int resp = 0;
        try {
            resp = st.executeUpdate(sql);
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    /**
     * Métoddo para Consultas DML - Data Manipulation Language.
     * 
     * @param sql Sentencia sql de algún método de los DAO.
     * @return Resulset con los datos que devuelve la BBDD.
     */
    public ResultSet executeQuery(String sql) {
        try {
            
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    /**
     * Método de desconexión con la BBDD.
     */
    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();

            }
            if (st != null) {
                st.close();

            }
            if (conn != null) {
                conn.close();

            }
        } catch (SQLException ex) {

        }
    }

}