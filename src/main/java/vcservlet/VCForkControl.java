package vcservlet;

import utils.JsonHelper;
import vcontrol.VControl;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VCForkControl {

    Logger log;
    private JsonHelper jsh;

    public VCForkControl(){
        jsh = new JsonHelper();
        log = Logger.getLogger(getClass().getName());
    }

    public String evalJSONEdge(String jsonInput) {
        log.log(Level.INFO, "*** VERSION CONTROL SERVICE - SPLIT JSON EDGE***");

        jsonInput = jsonInput.replaceAll("\"\"", "null");
        HashMap map = jsh.convertInputMap(jsonInput);

        VControl vc = new VControl();
        map = vc.onAddEdges(map);

        String response = jsh.convertInputJson(map);
        return response;
    }

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
