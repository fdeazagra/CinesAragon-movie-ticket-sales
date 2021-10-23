/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiREST;

import DAO.CineDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Cine;

/**
 * REST Web Service
 *
 * @author Fernando
 */
@Path("cine")
public class CineResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CineResource
     */
    public CineResource() {
    }

    /**
     * Retrieves representation of an instance of apiREST.CineResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST    
    @Path("/provincia")    
    @Consumes({MediaType.APPLICATION_JSON})    
    @Produces({MediaType.APPLICATION_JSON})    
    public String filtroProvincia(Cine entity) {            
        CineDAO cineDAO = new CineDAO(); 
        ArrayList<Cine> cines = cineDAO.filtroProvincia(entity.getProvincia());
        return Cine.toArrayJSon(cines);    
    }
    
    @POST    
    @Path("/nombre")    
    @Consumes({MediaType.APPLICATION_JSON})    
    @Produces({MediaType.APPLICATION_JSON})    
    public String filtroNombre(Cine entity) {            
        CineDAO cineDAO = new CineDAO(); 
        ArrayList<Cine> cines = cineDAO.filtroNombre(entity.getNombre());
        return Cine.toArrayJSon(cines);    
    }

    /**
     * PUT method for updating or creating an instance of CineResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
