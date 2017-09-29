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

    /**
     * Say hello to the world to check the service is running correctly.
     *
     * @return Hello World!
     */
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World!";
    }

    /**
     * Get a list of Tweets referring to a Topic.
     *
     * @param inclusive Whether the Topic should be included or excluded in the query
     * @param topicName The name of the Topic to search for
     * @param negated Whether the Topic is negated
     * @param genuine Whether the Topic is genuine
     * @return A list of Tweets referring to the specified Topic
     * @see Topic
     * @see Tweet
     */
    @GET
    @Path("/tweets/{inclusive}/{topic}/{negated}/{genuine}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> tweetsByTopic(@PathParam("inclusive") boolean inclusive,
                                     @PathParam("topic") String topicName,
                                     @PathParam("negated") boolean negated,
                                     @PathParam("genuine") boolean genuine) {

        Topic topic = new Topic(topicName, negated, genuine);
        return postgreSQLDB.tweetsForTopic(topic);
    }

    /**
     * Get a list of all Topics present in the database.
     *
     * @return A list of all known Topics
     * @see Topic
     */
    @GET
    @Path("/topics")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Topic> listTopics() {
        return postgreSQLDB.listTopics();
    }
}
