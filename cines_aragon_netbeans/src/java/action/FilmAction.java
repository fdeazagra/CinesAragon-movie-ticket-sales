package action;

import DAO.FilmDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Film;

/**
 * Clase con las acciones para operar con la entidad Film.
 * 
 * @author Fernando Martínez de Azagra Detraux
 */
public class FilmAction implements interfaces.IAction {
    
    /**
     * Localiza las consultas, redirecciona a sus DAOs
     * y carga la página con los resultados.
     * 
     * @param request
     * @param response
     * @return La página de retorno.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }
    
    /**
     * Realiza la consulta de todas las películas disponibles 
     * ordenadas por id.
     * 
     * @param request
     * @param response
     * @return La página de retorno.
     */
    private String findAll(HttpServletRequest request, 
                                HttpServletResponse response) {
        FilmDAO peliculaDao = new FilmDAO();
        ArrayList<Film> lstPeliculas = peliculaDao.findAll(null);
        return Film.toArrayJSon(lstPeliculas);
    }

    
}
