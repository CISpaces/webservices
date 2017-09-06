/**
 * This class is used to process the JSON coming from the front-end.
 * It puts the JSON strings into hashmaps. Then it passes the hashmap to class VControl which extracts the bits to be put in the database.
 *
 * @author Yordanka Ivanova
 * @since July 2017
 */
package vcservlet;

import com.google.gson.reflect.TypeToken;
import database.DBQuery;
import utils.JsonHelper;
import vcontrol.VControl;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VCForkControl {

    //a logger object which prints to stdout
    Logger log;

    //a helper object which is used to convert json to hashmaps
    //@see class JsonHelper in package utils
    private JsonHelper jsh;

    public VCForkControl(){
        jsh = new JsonHelper();
        log = Logger.getLogger(getClass().getName());
    }

    /**
     * @param jsonInput the json for an edge coming from the front-end
     * @return a string which indicates whether the conversion to hashmap has succeeded
     */
    public String evalJSONEdge(String jsonInput) {
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - SPLIT JSON EDGE***");

        jsonInput = jsonInput.replaceAll("\"\"", "null");
        HashMap map = jsh.convertInputMap(jsonInput);

        VControl vc = new VControl();
        map = vc.onAddEdges(map);

        String response = jsh.convertInputJson(map);
        return response;
    }

    /**
     * @param jsonInput the json for a node coming from the front-end
     * @return a string which indicates whether the conversion to hashmap has succeeded
     */
    public String evalJSONNode(String jsonInput) {
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - SPLIT JSON NODE");

        jsonInput = jsonInput.replaceAll("\"\"", "null");
        HashMap map = jsh.convertInputMap(jsonInput);

        VControl vc = new VControl();
        map = vc.onAddNodes(map);

        String response = jsh.convertInputJson(map);
        return response;
    }

    /**
     * @param graph the json for a graph coming from the client
     */
    public void evalJSONGraph(String graph) {
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - SPLIT JSON GRAPH");

        graph = graph.replaceAll("\"\"", "null");
        HashMap map = jsh.convertInputMap(graph);

        VControl vc = new VControl();
        vc.onAddGraph(map);

        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - NEW GRAPH ADDED SUCCESSFULLY;");
    }

    /**
     * @param userData the user credentials in a json string format
     * @return a string indicating whether the user has been validated successfully
     */
    public String evalJSONUser(String userData) {

        userData = userData.replaceAll("\"\"", "null");
        HashMap map = jsh.convertInputMap(userData);

        VControl vc = new VControl();
        String result = vc.onCheckUserExists(map);

        return result;
    }

    /**
     * @param graphIDTitleJSON a json containing the information of a graph which will be saved into the database
     * @return a string indicating whether the graph has been saved successfully
     */
    public String evalJSONSaveAnalysis(String graphIDTitleJSON) {
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - SPLIT JSON ON SAVE ANALYSIS");
        graphIDTitleJSON = graphIDTitleJSON.replaceAll("\"\"", "null");
        HashMap map = jsh.convertInputMap(graphIDTitleJSON);

        VControl vControl = new VControl();
        String result = vControl.onSaveAnalysis(map);

        return result;
    }


    public void evalJSONUpdateAnalysis(String analysis){
        HashMap map = jsh.convertInputMap(analysis);
        DBQuery dbQuery = new DBQuery();
        dbQuery.updateAnalysis(map);

    }
}
