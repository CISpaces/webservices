package fewsservlet;

import database.PostgreSQLDB;
import database.Tweet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class FEWSServlet {

    PostgreSQLDB postgreSQLDB;

    public FEWSServlet() {
        postgreSQLDB = new PostgreSQLDB();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World!";
    }

    @GET
    @Path("/tweets")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> tweets() {
        List<Tweet> tweetList = postgreSQLDB.tweetsForEntity("topic unrest");
        System.out.println("Hello");
        return tweetList;
    }

}
