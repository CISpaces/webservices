package fewsservlet;

import database.PostgreSQLDB;
import database.Topic;
import database.Tweet;
import database.VocabularyTopic;
import filters.JWTTokenNeeded;
import messagebus.MessageBus;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.ListIterator;
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
    @JWTTokenNeeded
    @POST
    @Path("/tweets")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tweet> tweetsByTopic(List<Topic> topicList, @Context HttpServletResponse response) {
        log.info("#### Getting Tweets");

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
    @JWTTokenNeeded
    @GET
    @Path("/topics")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Topic> listTopics(@Context HttpServletResponse response) {
        log.info("#### Getting Topics");

        List<Topic> topicList = postgreSQLDB.listTopics();
        ListIterator<Topic> topicListIterator = topicList.listIterator();
        while (topicListIterator.hasNext()) {
            response.setHeader("topic-" + topicListIterator.nextIndex(),
                    topicListIterator.next().toString());
        }
        return topicList;
    }

    @JWTTokenNeeded
    @GET
    @Path("/vocab")
    @Produces(MediaType.APPLICATION_JSON)
    public List<VocabularyTopic> getVocab() {
        log.info("#### Getting vocabulary");

        return postgreSQLDB.listVocab();
    }

    /**
     * Add a new Topic to Fact-Extraction's index.
     *
     * POST Request at FEWSROOT/topics/ with JSON representation of List of Topics
     */
    @JWTTokenNeeded
    @POST
    @Path("/vocab")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addVocab(VocabularyTopic vocabularyTopic, @Context HttpServletResponse response) {
        log.info("#### Adding VocabularyTopic: " + vocabularyTopic.getTopic());
        postgreSQLDB.addVocab(vocabularyTopic);

        // Send down RabbitMQ bus
        messageBus.send(VocabularyTopic.asControlMessage(getVocab()));

        return Response.status(Response.Status.CREATED).entity(vocabularyTopic.getTopic()).build();
        // TODO send conflict response if exists
    }

//    @JWTTokenNeeded
    @DELETE
    @Path("/vocab/{vocabTopicName}")
    public Response deleteVocabTopic(@PathParam("vocabTopicName") String vocabTopicName) {
        log.info("#### Deleting VocabularyTopic: " + vocabTopicName);
        postgreSQLDB.deleteVocabTopic(vocabTopicName);

        messageBus.send(VocabularyTopic.asControlMessage(getVocab()));

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/vocab/{vocabTopicName}/{vocabKeyword}")
    public Response deleteVocabTopic(@PathParam("vocabTopicName") String vocabTopicName,
                                     @PathParam("vocabKeyword") String vocabKeyword) {
        log.info("#### Deleting VocabularyTopic keyword: " + vocabTopicName + " - " + vocabKeyword);
        postgreSQLDB.deleteVocabKeyword(vocabTopicName, vocabKeyword);

        messageBus.send(VocabularyTopic.asControlMessage(getVocab()));

        return Response.status(Response.Status.OK).build();
    }

}
