package fewsservlet;

import database.Topic;
import database.PostgreSQLDB;
import database.Tweet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class FEWSServlet {

    private PostgreSQLDB postgreSQLDB;

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
    @Path("/tweets/{inclusive}/{entity}/{negated}/{genuine}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> tweetsByTopic(@PathParam("inclusive") boolean inclusive,
                                     @PathParam("entity") String entityName,
                                     @PathParam("negated") boolean negated,
                                     @PathParam("genuine") boolean genuine) {

        Topic topic = new Topic(entityName, negated, genuine);
        return postgreSQLDB.tweetsForTopic(topic);
    }

    @GET
    @Path("/topics")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Topic> listTopics() {
        return postgreSQLDB.listTopics();
    }
}
