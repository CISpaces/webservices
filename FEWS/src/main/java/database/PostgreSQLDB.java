package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles queries to the PostgreSQL database for FEWS (Fact Extraction Web Service)
 *
 * <p/>Queries return ArrayLists of Tweets and Topics.
 *
 * @see Tweet
 * @see Topic
 */
public class PostgreSQLDB {

    private Connection conn;
    private static Logger log;

    public PostgreSQLDB() {
        log = Logger.getLogger(getClass().getName());
    }

    /**
     * Connects to the Fact-Extraction PostgreSQL database.
     *
     * @return Was connection successful?
     */
    private boolean connect() {
        try {
            Class.forName("org.postgresql.Driver");
//            TODO put these in a config file
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://rsg-xen-vm04.ecs.soton.ac.uk:5432/factextract",
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

    /**
     * Closes the connection to the Fact-Extraction PostgreSQL database.
     *
     * @param rs SQL ResultSet to close
     * @param s SQL Statement to close
     * @param c SQL Connection to close
     */
    private void finalize(ResultSet rs, Statement s, Connection c) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException exc) { /* Ignored */ }
            try {
                s.close();
            } catch (SQLException exc) { /* Ignored */ }
            try {
                c.close();
            } catch (SQLException exc) { /* Ignored */ }
        }
    }



    // Stuart's single-topic query
//                    "SELECT " +
//                    "post.source_uri, post.text, extract.extract, extract.item_key " +
//                    "FROM " +
//                    "factextract.phase1_ext_db_item AS extract, " +
//                    "factextract.phase1_ext_db_topic_index AS index, " +
//                    "factextract.phase1_ext_db_topic AS topic, " +
//                    "factextract.phase1_post_db_item AS post " +
//                    "WHERE " +
//                    "extract.item_key = index.item_key AND " +
//                    "index.topic_key = topic.topic_key AND " +
//                    "topic.topic = ? AND " +
//                    "topic.negated IS NOT TRUE AND " +
//                    "topic.genuine IS NOT FALSE AND " +
//                    "post.source_uri = extract.source_uri"

    /**
     * Get a list of Tweets referring to the specified Topics.
     *
     * @param topicList List of Topics to which Tweets should refer
     * @return ArrayList of Tweets referring to the specified Topic
     * @see Topic
     * @see Tweet
     */
    public List<Tweet> tweetsForTopic(List<Topic> topicList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Tweet> tweetList = new ArrayList<>();

        try {
            if (!connect()) { return null; }

            // Build up the SQL query using a subquery for each topic - allows consistency
            StringBuilder queryString = new StringBuilder(
                    "SELECT DISTINCT ON (extract.item_key) " +
                    "extract.item_key, extract.extract, extract.source_uri " +
                    "FROM factextract.phase1_ext_db_item as extract " +
                    "JOIN factextract.phase1_ext_db_topic_index as topic_index " +
                    "ON (extract.item_key = topic_index.item_key) "
            );
            for (int i=0; i < topicList.size(); i++) {
                if (i == 0) {
                    queryString.append("WHERE extract.item_key IN ");
                } else {
                    queryString.append("AND extract.item_key IN ");
                }
                queryString.append(
                        "( " +
                            "SELECT DISTINCT topic_index.item_key " +
                            "FROM factextract.phase1_ext_db_topic as topic " +
                            "RIGHT JOIN factextract.phase1_ext_db_topic_index as topic_index " +
                            "ON (topic.topic_key = topic_index.topic_key) " +
                            "WHERE topic.topic = ? " +
                            "AND topic.negated IS NOT TRUE " +
                            "AND topic.genuine IS NOT FALSE " +
                        ") "
                );
            }
            queryString.append("ORDER BY extract.item_key;");

            statement = conn.prepareStatement(queryString.toString());
            for (int i=0; i < topicList.size(); i++) {
                Topic topic = topicList.get(i);
                statement.setString(i + 1, topic.getName());
//                statement.setString(3*i + 1, topic.getName());
//                statement.setBoolean(3*i + 2, topic.isNegated());
//                statement.setBoolean(3*i + 3, topic.isGenuine());
            }

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
            finalize(resultSet, statement, conn);
        }

        return tweetList;
    }

    /**
     * Get the list of all known Topics.
     *
     * @return List of all Topics present in database
     */
    public List<Topic> listTopics() {
        Statement statement = null;
        ResultSet resultSet = null;

        List<Topic> topicList = new ArrayList<>();

        try {
            if (!connect()) { return null; }

            String queryString =
                    "SELECT * " +
                    "FROM factextract.phase1_ext_db_topic;";

            statement = conn.createStatement();
            resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                String topicName = resultSet.getString("topic");
                boolean negated = resultSet.getBoolean("negated");
                boolean genuine = resultSet.getBoolean("genuine");

                topicList.add(new Topic(topicName, negated, genuine));
            }

        } catch (SQLException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB query", exc);
            exc.printStackTrace();
            return null;
        } finally {
            finalize(resultSet, statement, conn);
        }

        return topicList;
    }
}
