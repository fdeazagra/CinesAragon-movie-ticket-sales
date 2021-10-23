
package apiREST;

import DAO.FilmDAO;
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
import model.Cine;
import model.Film;

/**
 * REST Web Service
 *
 * @author Fernando
 */
@Path("peliculas")
public class PeliculasResource {

    @Context
    private UriInfo context;

    public PeliculasResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
        FilmDAO filmDao = new FilmDAO();
        ArrayList<Film> lstFilms = filmDao.findAll(null);
        return Film.toArrayJSon(lstFilms);
    }
    
    @GET
    @Path("/titulos")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTitulos() {
        
        FilmDAO filmDao = new FilmDAO();
        ArrayList<Film> lstFilms = filmDao.getTitulos();
        return Film.toArrayJSon(lstFilms);
    }
    
    @POST    
    @Path("/genero")    
    @Consumes({MediaType.APPLICATION_JSON})    
    @Produces({MediaType.APPLICATION_JSON})    
    public String filtroGenero(Film entity) {  
        
        FilmDAO filmDAO = new FilmDAO(); 
        ArrayList<Film> lstFilms = filmDAO.findByGenero(entity.getGenero());
        return Film.toArrayJSon(lstFilms);    
    }
    
    @POST
    @Path("/titulo")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String filtroTitulo(Film entity) {
        
        FilmDAO filmDAO = new FilmDAO(); 
        ArrayList<Film> lstFilms = filmDAO.findByTitulo(entity.getTitulo());
        return Film.toArrayJSon(lstFilms);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
