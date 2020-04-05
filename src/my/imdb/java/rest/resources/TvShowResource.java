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
import services.TvShow;
import services.TvShowWebService;
import services.TvShowWebService_Service;
/**
 *
 * @author davicarvalho
 */
@Path("shows")
public class TvShowResource {

    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll() {
        TvShowWebService_Service service = new TvShowWebService_Service();
        TvShowWebService port = service.getTvShowWebServicePort();
        List<TvShow> shows = port.listTvShows();
    	Gson gson = new Gson();
        return gson.toJson(shows);
    }
	
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String find(@PathParam("id") Integer id) {
    	TvShowWebService_Service service = new TvShowWebService_Service();
        TvShowWebService port = service.getTvShowWebServicePort();
        TvShow show = port.findTvShow(id);
    	Gson gson = new Gson();
        return gson.toJson(show);
    }
}
