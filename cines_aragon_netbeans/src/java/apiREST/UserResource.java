
package apiREST;

import DAO.TicketDAO;
import DAO.UserDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.User;
import model.Ticket;

/**
 * REST Web Service
 *
 * @author Fernando
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;

    public UserResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
        UserDAO userDao = new UserDAO();
        ArrayList<User> lstPeliculas = userDao.findAll(null);
        return User.toArrayJSon(lstPeliculas);
    }

    @POST    
    @Path("/login")    
    @Consumes({MediaType.APPLICATION_JSON})    
    @Produces({MediaType.APPLICATION_JSON})    
    public String login(User entity) {//email + password            
        UserDAO usuarioDAO = new UserDAO();        
        User usuario = new User();
        usuario.setNombre(entity.getNombre());
        usuario.setEmail(entity.getEmail());
        ArrayList<User> usuarios = usuarioDAO.findAll(usuario);
        return User.toArrayJSon(usuarios);    
    } 
    
    
    @POST
    @Path("/tickets")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String getTickets(User entity) {
        
        TicketDAO ticketDAO = new TicketDAO(); 
        ArrayList<Ticket> lstTickets = ticketDAO.getTickets(entity.getNombre());
        return Ticket.toArrayJSon(lstTickets);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
