/**
 *  This class consists of the SQL queries for creating the tables which enable the support of Version Control within the application.
 *  It also includes queries which will be executed on the back-end to accommodate front-end interaction with the program.
 *  The database used is Derby, so all queries are written to support the Derby SQL dialect.
 *
 *  @author Yordanka Ivanova
 *  @since July 2017
 */

package database;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class DBQuery {

    /*This object manages the connection to the database and the execution of queries
    * @see DBConnect in the database package
    */
    protected DBConnect dbcn;

    public DBQuery() {
        dbcn = new DBConnect();
    }

    public void createTableSession(){
        String query = "CREATE TABLE CISPACES_GRAPH ( graphid varchar (255), userid varchar(255), timest timestamp, isshared boolean, parentgraphid varchar(255), ";
        query+="CONSTRAINT CISPACES_GRAPH_pk PRIMARY KEY (graphid))";
        dbcn.updateSQL(query);
    }

    public void createTableSessionHistory(){
        String query = "CREATE TABLE CISPACES_GRAPH_HISTORY (revisionid varchar(255), graphid varchar(255), userid varchar(255), " +
                "timest timestamp, isshared boolean, parentgraphid varchar(255), ";
        query+="CONSTRAINT GRAPH_SESSION_HISTORY_pk PRIMARY KEY (revisionid))";
        dbcn.updateSQL(query);
    }

    public void createTableNode(){
        String query="CREATE TABLE CISPACES_NODE ( nodeid varchar(255), source varchar (255), uncert varchar(20), eval varchar(5000), "
                + "txt varchar (5000), inp varchar (20), dtg timestamp, cmt varchar(50), type varchar(10), annot varchar (5000), graphid varchar(255), "
                + "islocked boolean, ";
        query+="CONSTRAINT CISPACES_NODE_pk PRIMARY KEY (nodeid))";
        dbcn.updateSQL(query);
    }

    public void createTableNodeHistory(){
        String query="CREATE TABLE CISPACES_NODE_HISTORY ( nodeid varchar(255), source varchar (255), uncert varchar(20), eval varchar(5000), "
                + "txt varchar (5000), inp varchar (20), dtg timestamp, cmt varchar(50), type varchar(10), annot varchar (5000), graphid varchar(255), "
                + "islocked boolean, revisionid varchar(255), ";
        query+="CONSTRAINT CISPACES_NODE_HISTORY_pk PRIMARY KEY (revisionid))";
        dbcn.updateSQL(query);
    }

    public void createTableEdge(){
        String query="CREATE TABLE CISPACES_EDGE ( edgeid varchar(255), tonodeid varchar(255), fromnodeid varchar(255), formedgeid varchar(255)," +
                "graphid varchar(255), islocked boolean, ";
        query+="CONSTRAINT CISPACES_EDGE_pk (edgeid))";
        dbcn.updateSQL(query);
    }

    public void createTableEdgeHistory(){
        String query="CREATE TABLE CISPACES_EDGE_HISTORY ( edgeid varchar(255), tonodeid varchar(255), fromnodeid varchar(255), formedgeid varchar(255)," +
                "graphid varchar(255), islocked boolean, revisionid varchar(255), ";
        query+="CONSTRAINT CISPACES_EDGE_pk (revisionid))";
        dbcn.updateSQL(query);
    }

    public void dropAllTables(){
        String query="DROP TABLE IF EXISTS CISPACES_GRAPH, CISPACES_GRAPH_HISTORY, CISPACES_NODE, CISPACES_NODE_HISTORY, CISPACES_EDGE, CISPACES_EDGE_HISTORY";
        dbcn.updateSQL(query);
    }

    public void closeDatabase() {
        dbcn.forceClose();
    }

    public void insertGraph(String graphid, String userid, Timestamp timest, boolean isshared, String parentgraphid){
        String sql;
        sql = "INSERT INTO CISPACES_GRAPH(graphid, userid, timest, isshared, parentgraphid) VALUES "
                + "( '" + graphid + "' ,"
                + " '" + userid + "' ,"
                + " '" + timest + "' ,"
                + " '" + isshared + "' ,"
                + " '" + parentgraphid + "'"
                +" )";

        System.out.println(sql);
        dbcn.updateSQL(sql);
    }

    public void insertGraphHistory(String graphid, String userid, Timestamp timest, boolean isshared, String parentgraphid, String revisionID){
        String sql;
        sql = "INSERT INTO CISPACES_GRAPH_HISTORY (graphid, userid, timest, isshared, parentgraphid, revisionid) VALUES "
                + "( '" + graphid + "' ,"
                + " '" + userid + "' ,"
                + " '" + timest + "' ,"
                + " " + isshared + "' ,"
                + " " + parentgraphid + "' ,"
                + " '" + revisionID + "'"
                +" )";

        System.out.println(sql);
        dbcn.updateSQL(sql);
    }

    public void insertNode(String nodeID, String source, String uncert, String eval, String txt, String input,
                           Timestamp timestamp, String commit, String type, String annot, String graphID, boolean isLocked)
    {
        String sql;
        sql = "Select * from CISPACES_NODE WHERE nodeid = " + "'" + nodeID + "'";
        ArrayList<HashMap<String,Object>> rs = dbcn.execSQL(sql);
        if(rs.isEmpty()){
            System.out.println("NODE DOESNT EXIST");
            sql = "INSERT INTO CISPACES_NODE (nodeid, source, uncert, eval, txt, inp, dtg, cmt, type, annot, graphid, islocked) VALUES "
                    + "( '"+nodeID+"' ,"
                    + " '"+source+"' ,"
                    + " '"+uncert+"' ,"
                    + " '"+eval+"' ,"
                    + " '"+txt+"' ,"
                    + " '"+input+"' ,"
                    + " '"+timestamp+"' ,"
                    + " '"+commit+"' ,"
                    + " '"+type+"' ,"
                    + " '"+annot+"' ,"
                    + " '"+graphID+"'"
                    + " '"+isLocked+"'"
                    + " )";
            System.out.println(sql);
        }else{
            System.out.println("NODE EXISTS");
            sql = "UPDATE CISPACES_NODE SET uncert = " + "'" + uncert + "'" + " ,"
                                        + " eval = " + "'" + eval + "'" + " ,"
                                        + " txt = "  + "'" + txt + "'" + " ,"
                                        + " inp = "  + "'" + input + "'" + " ,"
                                        + " cmt = "  + "'" + commit + "'" + " ,"
                                        + " annot = " + "'" + annot + "'"
                    + " WHERE nodeid = " + "'" + nodeID + "'";
            System.out.println(sql);
        }

        dbcn.updateSQL(sql);
    }

    public void insertNodeHistory(String nodeID, String source, String uncert, String eval, String txt, String input,
                           Timestamp timestamp, String commit, String type, String annot, String graphID, boolean isLocked, String revisionID)
    {
        String sql;
        sql = "Select * from CISPACES_NODE_HISTORY WHERE nodeid = " + "'" + nodeID + "'";
        ArrayList<HashMap<String,Object>> rs = dbcn.execSQL(sql);
        if(rs.isEmpty()){
            System.out.println("NODE DOESNT EXIST IN HISTORY TABLE");
            sql = "INSERT INTO CISPACES_NODE_HISTORY (nodeid, source, uncert, eval, txt, inp, dtg, cmt, type, annot, graphid, islocked, revisionid) VALUES "
                    + "( '"+nodeID+"' ,"
                    + " '"+source+"' ,"
                    + " '"+uncert+"' ,"
                    + " '"+eval+"' ,"
                    + " '"+txt+"' ,"
                    + " '"+input+"' ,"
                    + " '"+timestamp+"' ,"
                    + " '"+commit+"' ,"
                    + " '"+type+"' ,"
                    + " '"+annot+"' ,"
                    + " '"+graphID+"'"
                    + " '"+isLocked+"'"
                    + " '"+revisionID+"'"
                    + " )";
            System.out.println(sql);
        }else{
            System.out.println("NODE EXISTS IN HISTORY TABLE");
            sql = "UPDATE CISPACES_NODE SET uncert = " + "'" + uncert + "'" + " ,"
                    + " eval = " + "'" + eval + "'" + " ,"
                    + " txt = "  + "'" + txt + "'" + " ,"
                    + " inp = "  + "'" + input + "'" + " ,"
                    + " cmt = "  + "'" + commit + "'" + " ,"
                    + " annot = " + "'" + annot + "'" + " ,"
                    + " islocked = " + "'" + isLocked + "'"
                    + " WHERE nodeid = " + "'" + nodeID + "'";
            System.out.println(sql);
        }

        dbcn.updateSQL(sql);
    }

    public void insertEdge(String toID, String fromID, String formEdgeID, String edgeID, String graphID, boolean isLocked) {
        String sql;
        sql = "Select * from CISPACES_EDGE WHERE edgeid = " + "'" + edgeID + "'";
        ArrayList<HashMap<String,Object>> rs = dbcn.execSQL(sql);
        if(rs.isEmpty()) {
            System.out.println("EDGE DOESNT EXIST");
            sql = "INSERT INTO CISPACES_EDGE (edgeid, tonodeid, fromnodeid, formedgeid, graphid, islocked) VALUES "
                    + "( '" + edgeID + "' ,"
                    + " '" + toID + "' ,"
                    + " '" + fromID + "' ,"
                    + " '" + formEdgeID + "' ,"
                    + " '" + graphID + "' ,"
                    + " '" + isLocked + "'"
                    + " )";
            dbcn.updateSQL(sql);
        }

        System.out.println(sql);

    }

    public void insertEdgeHistory(String toID, String fromID, String formEdgeID, String edgeID, String graphID, boolean isLocked, String revisionID) {
        String sql;
        sql = "Select * from CISPACES_EDGE WHERE edgeid = " + "'" + edgeID + "'";
        ArrayList<HashMap<String,Object>> rs = dbcn.execSQL(sql);
        if(rs.isEmpty()) {
            System.out.println("EDGE DOESNT EXIST IN HISTORY TABLE");
            sql = "INSERT INTO CISPACES_EDGE (edgeid, tonodeid, fromnodeid, formedgeid, graphid, islocked, revisionid) VALUES "
                    + "( '" + edgeID + "' ,"
                    + " '" + toID + "' ,"
                    + " '" + fromID + "' ,"
                    + " '" + formEdgeID + "' ,"
                    + " '" + graphID + "' ,"
                    + " '" + isLocked + "' ,"
                    +  " '" + revisionID + "'"
                    + " )";
            dbcn.updateSQL(sql);
        }

        System.out.println(sql);

    }

    public boolean deleteEdge(String edgeid) {
        String sql = "DELETE FROM CISPACES_EDGE WHERE edgeid = " + "'" + edgeid + "'";
        System.out.println(sql);
        boolean isStatementExecuted = dbcn.updateSQL(sql);

        return isStatementExecuted;
    }

    public boolean deleteNode(String nodeid) {
        String sql = "DELETE FROM CISPACES_NODE WHERE nodeid = " + "'" + nodeid + "'";
        System.out.println(sql);
        boolean isStatementExecuted = dbcn.updateSQL(sql);

        return isStatementExecuted;
    }

    public String checkUserExists(String username, String password, String aff) {
        String sql = "SELECT * from CISPACES_USERS WHERE USERNAME = " + "'" + username + "'" + " AND PASSWORD = " +  "'" + password + "'" + " AND AFFILIATION = " +  "'" + aff + "'";
        System.out.println(sql);
        String response;
        ArrayList<HashMap<String,Object>> rs = dbcn.execSQL(sql);
        if(rs.isEmpty()){
            response = "fail";
        }else{
            response = "success";
        }

        return response;
    }
}
