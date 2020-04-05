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
import services.Episode;
import services.EpisodeWebService;
import services.EpisodeWebService_Service;
/**
 *
 * @author davicarvalho
 */
@Path("episodes")
public class EpisodeResource {

    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll() {
        EpisodeWebService_Service service = new EpisodeWebService_Service();
        EpisodeWebService port = service.getEpisodeWebServicePort();
        List<Episode> episodes = port.listEpisodes();
    	Gson gson = new Gson();
        return gson.toJson(episodes);
    }
	
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String find(@PathParam("id") Integer id) {
    	EpisodeWebService_Service service = new EpisodeWebService_Service();
        EpisodeWebService port = service.getEpisodeWebServicePort();
        List<Episode> episodes = port.findEpisodeBySeason(id);
    	Gson gson = new Gson();
        return gson.toJson(episodes);
    }
}
