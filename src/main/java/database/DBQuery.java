package database;

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
        String query="CREATE TABLE CISPACES_NODE ( nodeid varchar(255), username varchar (255), eval CLOB (50 KB), txt CLOB (50 KB), input varchar (20), dtg timestamp, " +
                "type varchar(10), annot CLOB (50 KB), prov clob (500 KB), sessionid varchar(255),";
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

}
