/**
 * This class contains the methods that handle the HTTP requests coming from the front-end.
 *
 * @author Yordanka Ivanova
 * @since July 2017
 */

package vcservlet;

import database.DBQuery;
import vcontrol.VControl;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * URL is http://localhost:8080/VC/rest/ for the server side
 */
@Path("/")
public class VCServlet {

    //a logger which prints to stdout
    private static Logger log;

    public VCServlet(){
        log = Logger.getLogger(getClass().getName());
    }

    //this method is here just to make sure the service is up and running
    //URL http://localhost:8080/VC/rest/getInfo
    @GET
    @Path("/getInfo")
    @Produces("text/html")
    public String sayHello(){
        return "Hello Jersey";
    }

    /**
     * @param graphID a graph id
     * @return all saved variations of an analysis which can be imported into the work box
     * URL: http://localhost:8080/VC/rest/history
     */
    @GET
    @Path("/history")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHistory(@CookieParam("graph_id") String graphID){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - GET HISTORY REQUEST ***");
        DBQuery dbQuery  = new DBQuery();
        String response = dbQuery.getHistoryOfAnalysis(graphID);

        return response;
    }

    /**
     * @param userID a user id coming from the client
     * @return either a json representing the latest analysis this user has worked on, or a new graph id for starting a new analysis
     * URL: http://localhost:8080/VC/rest/getAnalysis
     */
    @POST
    @Path("/getAnalysis")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLatestAnalysis(String userID)
    {
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - GET LATEST ANALYSIS REQUEST ***");
        log.log(Level.INFO, "user id payload " + userID);
        DBQuery dbQuery  = new DBQuery();
        String response = dbQuery.getLatestAnalysis(userID);

        return response;
    }


    /**
     * @param userData a json containing the user login details
     * @return a response indicating whether the user has been validated
     * URL: http://localhost:8080/VC/rest/user
     */
    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String checkUser(String userData){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - Login Request ***");
        log.log(Level.INFO, "Login payload " + userData);
        VCForkControl vcForkControl = new VCForkControl();
        String response = vcForkControl.evalJSONUser(userData);

        return response;
    }

    /**
     * @param graph a json containing the basic information for a new graph
     * @return a response indicating whether the graph has been inserted into the database
     * URL: http://localhost:8080/VC/rest/new
     */
    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNewGraph(String graph){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - New Graph Request ***");

        VCForkControl vcControl = new VCForkControl();
        vcControl.evalJSONGraph(graph);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - New Graph Request Handled ***");

    }

    /**
     * @param graphInfo a json containing the graph id, the creator of the analysis' id and the title of the analysis
     * @return a response indicating whether the analysis has been saved
     * URL: http://localhost:8080/VC/rest/save
     */
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String saveGraph(String graphInfo){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - Save Graph Request ***");

        VCForkControl vcForkControl = new VCForkControl();
        String result = vcForkControl.evalJSONSaveAnalysis(graphInfo);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - Save Graph Request Handled ***");

        return result;
    }


    /**
     * @param edge the JSON for an edge coming from the front-end upon the creation of a new edge
     * @return a response indicating whether the JSON has been processed and the relevant bits put into the database
     * URL: http://localhost:8080/VC/rest/edge/edgeid
     */
    @Path("/edge/{edgeid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getJSONInputEdge(String edge){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - New Edge Request ***");

        VCForkControl vcControl = new VCForkControl();
        String out = vcControl.evalJSONEdge(edge);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - Edge Request Handled ***");

        return out;
    }


    /**
     * @param json the JSON for a node coming from the front-end upon the creation of a new node
     * @return a response indicating whether the JSON has been processed and the relevant bits put into the database
     * URL: http://localhost:8080/VC/rest/node/nodeid
     */
    @Path("/node/{nodeid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getJSONInputNode(String json){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - New Node Request ***");

        VCForkControl vcControl = new VCForkControl();
        String out = vcControl.evalJSONNode(json);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - Node Request Handled ***");

        return out;
    }

    /**
     * @param json a string containing the data for the edge to be updated
     * @return a response indicating whether the JSON has been processed and the edge data updated in the database
     * URL: http://localhost:8080/VC/rest/edge/edgeid
     */
    @Path("/edge/{edgeid}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putEdge(String json){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - Put Edge Request ***");
        VCForkControl vcControl = new VCForkControl();
        String out = vcControl.evalJSONEdge(json);
        return out;
    }

    /**
     * @param json a string containing the data for the node to be updated
     * @return a response indicating whether the JSON has been processed and the node data updated in the database
     * URL: http://localhost:8080/VC/rest/node/nodeid
     */
    @Path("/node/{nodeid}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putNode(String json){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - Put Node Request ***");
        VCForkControl vcControl = new VCForkControl();
        String out = vcControl.evalJSONNode(json);
        return out;
    }


    /**
     * @param edgeid a string containing the id of the edge to be deleted
     * @return a response indicating whether the JSON has been processed and the edge deleted from the database
     * URL: http://localhost:8080/VC/rest/edge/edgeid
     */
    @Path("/edge/{edgeid}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteEdge(@PathParam("edgeid") String edgeid){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - Delete Edge Request ***");

        DBQuery dbQuery = new DBQuery();
        boolean isDeleted = dbQuery.deleteEdge(edgeid);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - Delete Edge Request Handled ***");

        return isDeleted;
    }

    /**
     * @param nodeid a string containing the id of the node to be deleted
     * @return a response indicating whether the JSON has been processed and the node deleted from the database
     * URL: http://localhost:8080/VC/rest/node/nodeid
     */
    @Path("/node/{nodeid}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteNode(@PathParam("nodeid") String nodeid){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - Delete Node Request ***");

        DBQuery dbQuery = new DBQuery();
        boolean isDelelted = dbQuery.deleteNode(nodeid);

        log.log(Level.INFO,"*** VERSION CONTROL SERVICE - Delete Node Request Handled ***");

        return isDelelted;
    }

    @Path("/updateAnalysis")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAnalysis(String analysis){
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - Update Analysis Request");

        VCForkControl vcForkControl = new VCForkControl();
        vcForkControl.evalJSONUpdateAnalysis(analysis);

    }

}
