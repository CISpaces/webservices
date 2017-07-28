package vcontrol;

import database.DBQuery;
import utils.TimeHelper;

import java.sql.Clob;
import java.sql.Timestamp;
import java.util.HashMap;

public class VControl {


    public HashMap onAddEdges(HashMap map) {

        String toID = map.get("toID").toString();
        String fromID = map.get("fromID").toString();
        String formEdgeID = "";
        if(map.get("formEdgeID") != null) {
            formEdgeID = map.get("formEdgeID").toString();
        }
        String edgeID = map.get("edgeID").toString();

        DBQuery dbQuery = new DBQuery();
        dbQuery.insertEdge(toID, fromID, formEdgeID, edgeID);

        map = new HashMap();
        map.put("response","success");

        return map;
    }

    public HashMap onAddNodes(HashMap map) {
        TimeHelper timeHelper = new TimeHelper();

        String nodeID = map.get("nodeID").toString();
        String username = map.get("source").toString();
        String eval = map.get("eval").toString();
        String txt = map.get("text").toString();
        String input = map.get("input").toString();
        Timestamp timestamp = timeHelper.formatDateCIS(map.get("dtg").toString());
        String type = map.get("type").toString();
        String annot = map.get("annot").toString();
      //  Clob prov =
        String sessionid = "testSession";

        DBQuery dbQuery = new DBQuery();
        dbQuery.insertNode(nodeID, username, eval, txt, input, timestamp, type, annot, sessionid);

        map = new HashMap();
        map.put("response","success");

        return map;
    }


}
