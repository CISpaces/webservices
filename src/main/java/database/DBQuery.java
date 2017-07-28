package database;

import java.sql.Timestamp;
import java.util.Calendar;

public class DBQuery {

    protected DBConnect dbcn;

    public DBQuery() {
        dbcn = new DBConnect();
    }

    public void createTableSession(){
        String query = "CREATE TABLE CISPACES_SESSION ( sessionid varchar (255), isTemp boolean, timest timestamp, isShared boolean, ";
        query+="CONSTRAINT CISPACES_SESSION_pk PRIMARY KEY (sessionid))";
        dbcn.updateSQL(query);
    }

    public void createTableSessionHistory(){
        String query = "CREATE TABLE CISPACES_SESSION_HISTORY (logid varchar(255), sessionid varchar(255), userid varchar(255), " +
                "action varchar(500),";
        query+="CONSTRAINT CISPACES_SESSION_HISTORY_pk PRIMARY KEY (logid))";
        dbcn.updateSQL(query);
    }

    public void createTableNode(){
        String query="CREATE TABLE CISPACES_NODE ( nodeid varchar(255), username varchar (255), eval varchar(5000), txt varchar (5000), inp varchar (20), dtg timestamp, " +
                "type varchar(10), annot varchar (5000), sessionid varchar(255),";
        query+="CONSTRAINT CISPACES_NODE_pk PRIMARY KEY (nodeid))";
        dbcn.updateSQL(query);
    }

    public void createTableEdge(){
        String query="CREATE TABLE CISPACES_EDGE ( edgeid varchar(255), tonodeid varchar(255), fromnodeid varchar(255), formedgeid varchar(255)," +
                "sessionid varchar(255),";
        query+="CONSTRAINT CISPACES_EDGE_pk (edgeid))";
        dbcn.updateSQL(query);
    }

    public void dropAllTables(){
        String query="DROP TABLE IF EXISTS CISPACES_SESSION, CISPACES_SESSION_HISTORY, CISPACES_NODE, CISPACES_EDGE";
        dbcn.updateSQL(query);
    }

    public void closeDatabase() {
        dbcn.forceClose();
    }

    public void insertSession(String sessionid, boolean isTemp, Calendar timest, boolean isShared){
        String sql;
        sql = "INSERT INTO CISPACES_SESSION (sessionid, isTemp, timest, isShared) VALUES "
                + "( '" + sessionid + "' ,"
                + " '" + isTemp + "' ,"
                + " '" + timest + "' ,"
                + " " + isShared + " )";

        System.out.println(sql);
        dbcn.updateSQL(sql);
    }

    public void insertNode(String nodeID, String username, String eval, String txt, String input, Timestamp timestamp, String type, String annot, String sessionid) {
        String sql;
        sql = "INSERT INTO CISPACES_NODE (nodeid, username, eval, txt, inp, dtg, type, annot, sessionid) VALUES "
                + "( '"+nodeID+"' ,"
                + " '"+username+"' ,"
                + " '"+eval+"' ,"
                + " '"+txt+"' ,"
                + " '"+input+"' ,"
                + " '"+timestamp+"' ,"
                + " '"+type+"' ,"
                + " '"+annot+"' ,"
                + " '"+sessionid+"'"
                        + " )";

        System.out.println(sql);
        dbcn.updateSQL(sql);
    }

    public void insertEdge(String toID, String fromID, String formEdgeID, String edgeID) {
        String sql;
        String temp = "testSession";
        sql = "INSERT INTO CISPACES_EDGE (edgeid, tonodeid, fromnodeid, formedgeid, sessionid) VALUES "
                + "( '"+edgeID+"' ,"
                + " '"+toID+"' ,"
                + " '"+fromID+"' ,"
                + " '"+formEdgeID+"' ,"
                + " '"+temp+"'"
                        + " )";

        System.out.println(sql);
        dbcn.updateSQL(sql);
    }


}
