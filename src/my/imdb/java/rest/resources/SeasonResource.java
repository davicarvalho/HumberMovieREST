/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.imdb.java.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import java.util.List;
import services.Season;
import services.SeasonWebService;
import services.SeasonWebService_Service;
/**
 *
 * @author davicarvalho
 */
@Path("seasons")
public class SeasonResource {

    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll() {
        SeasonWebService_Service service = new SeasonWebService_Service();
        SeasonWebService port = service.getSeasonWebServicePort();
        List<Season> seasons = port.listSeasons();
    	Gson gson = new Gson();
        return gson.toJson(seasons);
    }
	
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String find(@PathParam("id") Integer id) {
    	SeasonWebService_Service service = new SeasonWebService_Service();
        SeasonWebService port = service.getSeasonWebServicePort();
        List<Season> seasons = port.findSeasonsByShow(id);
    	Gson gson = new Gson();
        return gson.toJson(seasons);
    }
}
