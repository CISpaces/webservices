package fewsservlet;

import database.Topic;
import database.PostgreSQLDB;
import database.Tweet;
import messagebus.ControlMessage;
import messagebus.MessageBus;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/")
public class FEWSServlet {

    private PostgreSQLDB postgreSQLDB;
    private MessageBus messageBus = null;

    private static Logger log;

    public FEWSServlet() {
        log = Logger.getLogger(getClass().getName());

        postgreSQLDB = new PostgreSQLDB();
        messageBus = new MessageBus();
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
     * Get a list of Tweets referring to a List of Topics.
     *
     * POST Request at FEWSROOT/tweets with JSON body describing a List of Topics. e.g.:
     *
     * [
     *   {
     *     name: "topic name",
     *     negated: -1,
     *     genuine: -1
     *   }
     * ]
     *
     * The 'negated' and 'genuine' properties are booleans coded as integers where:
     *   1 represents True
     *   0 represents False
     *  -1 represents NULL or Unknown
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
     * @return A list of Tweets referring to the specified Topics
     * @see Topic
     * @see Tweet
     */
    // TODO multiple topics
    @POST
    @Path("/tweets")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tweet> tweetsByTopic(List<Topic> topicList, @Context HttpServletResponse response) {
        ListIterator<Topic> topicListIterator = topicList.listIterator();
        while (topicListIterator.hasNext()) {
            response.setHeader("topic-" + topicListIterator.nextIndex(),
                    topicListIterator.next().toString());
        }
        return postgreSQLDB.tweetsForTopic(topicList);
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
    public List<Topic> listTopics(@Context HttpServletResponse response) {
        List<Topic> topicList = postgreSQLDB.listTopics();
        ListIterator<Topic> topicListIterator = topicList.listIterator();
        while (topicListIterator.hasNext()) {
            response.setHeader("topic-" + topicListIterator.nextIndex(),
                    topicListIterator.next().toString());
        }
        return topicList;
    }


    /**
     * Add a new Topic to Fact-Extraction's index.
     *
     * POST Request at FEWSROOT/topics/{topicName} where 'topicName' is the new topic to add to Fact-Extraction's index
     *
     * @param topicName Topic to add to index
     * @return "OK" if message was sent, else "NOK"
     */
    @POST
    @Path("/topics/{topicName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addTopic(@PathParam("topicName") String topicName) {
        ControlMessage cMessage = new ControlMessage(topicName);
        return messageBus.sendMessage(cMessage) ? "OK" : "NOK";
    }
}
