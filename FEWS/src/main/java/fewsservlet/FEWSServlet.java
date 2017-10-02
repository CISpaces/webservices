package fewsservlet;

import database.Topic;
import database.PostgreSQLDB;
import database.Tweet;
import messagebus.MessageBus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/")
public class FEWSServlet {

    private PostgreSQLDB postgreSQLDB;
    private MessageBus messageBus;

    private static Logger log;

    public FEWSServlet() {
        log = Logger.getLogger(getClass().getName());

        postgreSQLDB = new PostgreSQLDB();
        try {
            messageBus = new MessageBus();
        } catch (java.io.IOException | java.util.concurrent.TimeoutException exc) {
            log.log(Level.SEVERE, "Failed to open RabbitMQ message bus", exc);
            exc.printStackTrace();
        }
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


    /**
     * Add a new Topic to Fact-Extraction's index.
     *
     * @param message Topic to add to index
     * @return
     */
    @POST
    @Path("/control/{message}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendMessage(@PathParam("message") String message) {
        if (messageBus.sendMessage(message)) {
            return "OK";
        } else {
            return "NOK";
        }
    }
}
