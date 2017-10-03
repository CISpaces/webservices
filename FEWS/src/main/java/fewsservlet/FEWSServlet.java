package fewsservlet;

import database.Topic;
import database.PostgreSQLDB;
import database.Tweet;
import messagebus.MessageBus;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
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
     * GET Request at FEWSROOT/tweets/{inclusive}/{topic}/{negated}/{genuine}
     * Boolean values must be "true" or "false". e.g.:
     *
     * FEWSROOT/tweets/true/topic%20unrest/false/true
     *
     * Returns a list of Tweets in JSON representation. e.g.:
     *
     * [
     *   {
     *     id: 11,
     *     extract: "text extract of Tweet",
     *     uri: "Twitter URI"
     *   },
     *   {
     *     id: 23,
     *     extract: "another text extract of Tweet",
     *     uri: "another Twitter URI"
     *   },
     *   ...
     * ]
     *
     * @param inclusive Whether the Topic should be included or excluded in the query
     * @param topicName The name of the Topic to search for
     * @param negated Whether the Topic is negated
     * @param genuine Whether the Topic is genuine
     * @return A list of Tweets referring to the specified Topic
     * @see Topic
     * @see Tweet
     */
    // TODO consider whether it's clearer to use QueryParam instead
    // TODO inclusive is currently ignored
    // TODO multiple topics
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
     * Get a list of Tweets referring to a Topic.
     *
     * POST Request at FEWSROOT/tweets with JSON body describing a Topic. e.g.:
     *
     * {
     *   name: "topic name",
     *   negated: false,
     *   genuine: true
     * }
     *
     * Returns a list of Tweets in JSON representation. e.g.:
     *
     * [
     *   {
     *     id: 11,
     *     extract: "text extract of Tweet",
     *     uri: "Twitter URI"
     *   },
     *   {
     *     id: 23,
     *     extract: "another text extract of Tweet",
     *     uri: "another Twitter URI"
     *   },
     *   ...
     * ]
     *
     * @return A list of Tweets referring to the specified Topic
     * @see Topic
     * @see Tweet
     */
    // TODO inclusive is currently ignored
    // TODO multiple topics
    @POST
    @Path("/tweets")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tweet> tweetsByTopic2(Topic topic, @Context HttpServletResponse response) {
        response.setHeader("topic", topic.toString());
        return postgreSQLDB.tweetsForTopic(topic);
    }

    /**
     * Get a list of all Topics present in the database.
     *
     * GET Request at FEWSROOT/topics
     * Returns all Topics, including combinations of 'negated' and 'genuine'.
     * i.e. a Topic name may appear twice with a different value of 'negated'
     *
     * Topics are returned in JSON representation. e.g.
     *
     * [
     *   {
     *     name: "topic a",
     *     negated: false,
     *     genuine: true
     *   },
     *   {
     *     name: "topic b",
     *     negated: true,
     *     genuine: false
     *   },
     *   ...
     * ]
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
     * POST Request at FEWSROOT/control/{message} where 'message' is the new topic to add to Fact-Extraction's index
     *
     * @param message Topic to add to index
     * @return "OK" if message was send, else "NOK"
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
