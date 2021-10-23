package DAO;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;
import utils.MotorMySQL;


/**
 * Clase con las consultas a la BBDD de la entidad Usuario.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class UserDAO implements IDAO<User, Integer>{
    
    private final String SQL_FINDALL
            = "SELECT * FROM `user` WHERE 1=1 ";
    
    private MotorMySQL motorSql;
    
    /**
     * Constructor que instancia un objeto de la clase MotorSQL
     * con los métodos de conexión a la BBDD.
     */
    public UserDAO() {
        this.motorSql = new MotorMySQL();
    }
    @Override
    public int add(User bean) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /** 
     * Busca si existe un usuario registrado en la BBDD con los 
     * datos recogidos en pantalla.
     * 
     * @param bean con los datos recogidos en pantalla.
     * @return Arraylist con el usuario si lo encuentra registrado en la BBDD
     * y si no lo encuentra, devuelve el Arraylist vacío.
     */
    @Override
    public ArrayList<User> findAll(User bean) {
        ArrayList<User> usuarios = new ArrayList<>();
        String sql= SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getId() != 0) {
                    sql += "AND id_user='" + bean.getId() + "'";
                }
                
                if (bean.getNombre() != null) {
                    sql += "AND nombre='" + bean.getNombre() + "'";
                }

                if (bean.getEmail() != null) {
                    sql += "AND email='" + bean.getEmail() + "'";
                }
                
                if (bean.getPassword() != null) {
                    sql += "AND pass ='" + bean.getPassword() + "'";
                }
                
            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                User usuario = new User();

               
                usuario.setNombre(rs.getString(2));
                usuario.setEmail(rs.getString(3));
                usuario.setPassword(rs.getString(4));
              

                usuarios.add(usuario);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return usuarios;
    }

    @Override
    public int update(User bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        /*PRUEBAS UNITARIAS - TEST*/
        UserDAO usuarioDAO = new UserDAO();
        
        //Findall - filtra segun campos que no son null o 0
        User usuario = new User();
            usuario.setEmail("fer@mail.com");
            usuario.setPassword("1234");
            usuario.setNombre("Fernando");
        ArrayList<User> lstUsuarios
                = usuarioDAO.findAll(usuario);
        System.out.println(lstUsuarios.toString());
    }
}
