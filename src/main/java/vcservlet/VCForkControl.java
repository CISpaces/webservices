/**
 * This class is used to process the JSON coming from the front-end.
 * It puts the JSON strings into hashmaps. Then it passes the hashmap to class VControl which extracts the bits to be put in the database.
 *
 * @author Yordanka Ivanova
 * @since July 2017
 */
package vcservlet;

import utils.JsonHelper;
import vcontrol.VControl;

import java.util.HashMap;
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
}
