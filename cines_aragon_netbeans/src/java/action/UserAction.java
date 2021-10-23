package action;

import DAO.UserDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import interfaces.IAction;

/**
 * Clase con las acciones para operar con la entidad User.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class UserAction implements IAction{
    
    /**
     * Recoge la acción a realizar y redirecciona a la página adecuada.
     * 
     * @param request
     * @param response
     * @return La página de retorno.
     */
    @Override
    public String execute(HttpServletRequest request,
            HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "LOGIN":
                cadDestino = login(request, response);
            break;
        }
    return cadDestino;
    }
    
    /**
     * Recoge los datos introducidos en el login de usuario
     * y comprueba si están registrados en la BBDD.
     * 
     * @param request
     * @param response
     * @return Array en Json con los datos del usuario.
     */
    private String login(HttpServletRequest request,
            HttpServletResponse response) {

        String nombre = request.getParameter("NOMBRE");
        String email =  request.getParameter("EMAIL");
        String password = request.getParameter("PASSWORD");
        User usuario = new User();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        UserDAO usuarioDao = new UserDAO();
        ArrayList<User> usuarios = usuarioDao.findAll(usuario);

        return User.toArrayJSon(usuarios); 
    }
}
    

