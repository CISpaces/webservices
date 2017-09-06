/**
 * This class takes the hashmap into which the JSON from the front-end has been parsed.
 * It extracts the relevant keys from the hashmap and passes them to class DBQuery which manages the queries to be executed.
 *
 * @author Yordanka Ivanova
 * @since July 2017
 */

package vcontrol;

import database.DBQuery;
import utils.TimeHelper;

import java.sql.Timestamp;
import java.util.HashMap;

public class VControl {

    /**
     * @param map the hashmap which contains the keys from the JSON of an edge and their respective values
     * @return a hashmap with key: 'response' and value: 'success' if the data has been put into the db or 'fail' if some error occurred
     */
    public HashMap onAddEdges(HashMap map) {

        String toID = map.get("target").toString();
        String fromID = map.get("source").toString();
        String formEdgeID = null;
        if(map.get("formEdgeID") != null) {
            formEdgeID = map.get("formEdgeID").toString();
        }
        String edgeID = map.get("edgeID").toString();
        String graphID = null;
        if(map.get("graphID") != null){
            graphID = map.get("graphID").toString();
        }

        boolean isLocked = false;
        if(map.get("isLocked") != null){
            Boolean.parseBoolean(map.get("isLocked").toString());
        }

        DBQuery dbQuery = new DBQuery();
        dbQuery.insertEdge(toID, fromID, formEdgeID, edgeID, graphID, isLocked);

        map = new HashMap();
        map.put("response","success");

        return map;
    }

    /**
     * @param map the hashmap which contains the keys from the JSON of a node and their respective values
     * @return a hashmap with key: 'response' and value: 'success' if the data has been put into the db or 'fail' if some error occurred
     * Note that the nodes have varying number of keys in the JSON, thus they are checked for null.
     */
    public HashMap onAddNodes(HashMap map) {
        TimeHelper timeHelper = new TimeHelper();

        String nodeID = map.get("nodeID").toString();

        String source = null;
        if(map.get("source") != null) {
            source = map.get("source").toString();
        }

        String uncert = null;
        if(map.get("uncert") != null) {
            uncert = map.get("uncert").toString();
        }

        String eval = null;
        if(map.get("eval") != null) {
           eval = map.get("eval").toString();
        }

        String txt = null;
        if(map.get("text") != null) {
            txt = map.get("text").toString();
        }

        String input = null;
        if(map.get("input") != null) {
            input = map.get("input").toString();
        }

        Timestamp timestamp = null;
        if(map.get("dtg") != null) {
            timestamp = timeHelper.formatDateCIS(map.get("dtg").toString());
        }


        String commit = null;
        if(map.get("commit") != null) {
            commit = map.get("commit").toString();
        }

        String type = null;
        if(map.get("type") != null) {
             type = map.get("type").toString();
        }

        String annot = "N/A";
        if(map.get("annot") != null) {
            annot = map.get("annot").toString();
        }
      //  Clob prov =
        String graphID = "N/A";
        if(map.get("graphID") != null) {
            graphID = map.get("graphID").toString();
        }

        boolean isLocked = false;
        if(map.get("isLocked") != null){
            Boolean.parseBoolean(map.get("isLocked").toString());
        }

        DBQuery dbQuery = new DBQuery();
        dbQuery.insertNode(nodeID, source, uncert, eval, txt, input, timestamp, commit, type, annot, graphID, isLocked);

        map = new HashMap();
        map.put("response","success");

        return map;
    }

    /**
     * @param map the hashmap which contains the keys from the JSON of a graph
     */
    public void onAddGraph(HashMap map) {
        TimeHelper timeHelper = new TimeHelper();
        String graphID = map.get("graphID").toString();
        String userID = map.get("userID").toString();
        Timestamp timestamp = timeHelper.formatDateCIS(map.get("timest").toString());
        boolean isShared = Boolean.parseBoolean(map.get("isshared").toString());
        String parentGraphID = null;
        if(map.get("parentgraphid") != null){
            parentGraphID = map.get("parentgraphid").toString();
        }


        DBQuery dbQuery = new DBQuery();
        dbQuery.insertGraph(graphID, userID, timestamp, isShared, parentGraphID);
    }

    /**
     * @param map the hashmap which contains user credentials
     * @return a string indicating whether the validation of a user has been successful
     */
    public String onCheckUserExists(HashMap map) {
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String aff = null;
        if(map.get("affiliation") != null){
            aff = map.get("affiliation").toString();
        }

        DBQuery dbQuery = new DBQuery();
        String result = dbQuery.checkUserExists(username, password, aff);
        return result;
    }

    /**
     * @param map the hashmap which contains a graph id, the id of the creator of the analysis and a title for the analysis
     * @return a string indicating whether the analysis has been saved successfully
     */
    public String onSaveAnalysis(HashMap map) {
        String graphID = map.get("graphID").toString();
        String title = null;
        if(map.get("title") != null){
            title = map.get("title").toString();
        }
        String userID = map.get("userID").toString();

        DBQuery dbQuery = new DBQuery();
        String result = dbQuery.saveLatestAnalysis(graphID,userID,title);
        return result;
    }
}
