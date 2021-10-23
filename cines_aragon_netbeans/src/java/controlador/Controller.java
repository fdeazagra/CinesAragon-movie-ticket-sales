package controlador;

import action.FilmAction;
import action.UserAction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet frontal que recibe todas las peticiones y filtra las acciones
 * correspondientes a cada entidad.
 * 
 * @author Fernando Martínez de Azagra
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    /**
     * Filtra las acciones para cada entidad.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                response.setContentType("text/plain;charset=UTF-8");
                PrintWriter out = response.getWriter();
                
                String action = request.getParameter("ACTION");
                String arrayAction[] = action.split("\\.");
                
                switch (arrayAction[0]) {
                    
                    // PELICULA.FIND_ALL
                    case "PELICULA":
                        out.print(new FilmAction().
                                execute(request, response));
                        break;
                        
                    //USUARIO.LOGIN
                    case "USUARIO":
                        out.print(new UserAction().
                                execute(request, response));
                        break;
                    default:
                        break;
                 }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
