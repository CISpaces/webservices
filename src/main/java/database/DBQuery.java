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
        String query="CREATE TABLE CISPACES_NODE ( nodeid varchar(255), source varchar (255), uncert varchar(20), eval varchar(5000), "
                + "txt varchar (5000), inp varchar (20), dtg timestamp, cmt varchar(50), type varchar(10), annot varchar (5000), sessionid varchar(255),";
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

    public void insertNode(String nodeID, String source, String uncert, String eval, String txt, String input,
                           Timestamp timestamp, String commit, String type, String annot, String sessionid)
    {
        String sql;
        sql = "Select * from CISPACES_NODE WHERE nodeid = " + "'" + nodeID + "'";
        ArrayList<HashMap<String,Object>> rs = dbcn.execSQL(sql);
        if(rs.isEmpty()){
            System.out.println("NODE DOESNT EXIST");
            sql = "INSERT INTO CISPACES_NODE (nodeid, source, uncert, eval, txt, inp, dtg, cmt, type, annot, sessionid) VALUES "
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
                    + " '"+sessionid+"'"
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
}
