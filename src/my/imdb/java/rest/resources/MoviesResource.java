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
import services.Movie;
import services.MovieWebService;
import services.MovieWebService_Service;
/**
 *
 * @author davicarvalho
 */
@Path("movies")
public class MoviesResource {

    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll() {
        MovieWebService_Service service = new MovieWebService_Service();
        MovieWebService port = service.getMovieWebServicePort();
        List<Movie> movies = port.listMovies();
    	Gson gson = new Gson();
        return gson.toJson(movies);
    }
	
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String find(@PathParam("id") Integer id) {
    	MovieWebService_Service service = new MovieWebService_Service();
        MovieWebService port = service.getMovieWebServicePort();
        Movie movie = port.findMovie(id);
    	Gson gson = new Gson();
        return gson.toJson(movie);
    }
}
