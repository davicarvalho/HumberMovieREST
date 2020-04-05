/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.imdb.java.rest;

import java.net.URI;
import java.io.IOException;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
/**
 *
 * @author davicarvalho
 */
public class Sever {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        ResourceConfig config = new ResourceConfig().packages("my.imdb.java.rest");
        config.register(CorsFilter.class);
        URI uri = URI.create("http://localhost:8081/");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
        System.out.println("Server running");
        System.in.read();
        server.stop();
    }
    
}
