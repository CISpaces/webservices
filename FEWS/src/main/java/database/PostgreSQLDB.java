package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDB {

    private Connection conn;
    private static Logger log;

    public PostgreSQLDB() {
        log = Logger.getLogger(getClass().getName());
    }

    private boolean connect() {
        try {
            Class.forName("org.postgresql.Driver");
//            TODO put these in a config file - and use localhost
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.124.122:5432/factextract",
                    "factextract",
                    "passw0rd"
            );
            return true;
        } catch (SQLException | ClassNotFoundException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB connection", exc);
            exc.printStackTrace();
            return false;
        }
    }

    public List<Tweet> tweetsForEntity(String entity) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Tweet> tweetList = new ArrayList<Tweet>();

        try {
            if (!connect()) { return null; }
            String queryString =
                    "SELECT extract.item_key, extract.extract, extract.source_uri " +
                    "FROM factextract.phase1_ext_db_topic as topic " +
                    "JOIN factextract.phase1_ext_db_topic_index as topic_index " +
                    "ON (topic.topic_key = topic_index.topic_key) " +
                    "JOIN factextract.phase1_ext_db_item as extract " +
                    "ON (extract.item_key = topic_index.item_key) " +
                    "WHERE topic.topic = ? " +
                    "LIMIT 10;";

            statement = conn.prepareStatement(queryString);
            statement.setString(1, entity);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("item_key");
                String extract = resultSet.getString("extract");
                String uri = resultSet.getString("source_uri");

                tweetList.add(new Tweet(id, extract, uri));
            }

        } catch (SQLException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB query", exc);
            exc.printStackTrace();
            return null;
        } finally {
           if (resultSet != null) {
               try {
                   resultSet.close();
               } catch (SQLException exc) { /* Ignored */ }
               try {
                   statement.close();
               } catch (SQLException exc) { /* Ignored */ }
               try {
                   conn.close();
               } catch (SQLException exc) { /* Ignored */ }
           }
        }

        return tweetList;
    }
}
