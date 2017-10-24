package database;

import java.io.InputStream;
import java.sql.*;
import java.util.*;
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

        Properties prop = new Properties();
        InputStream input = null;

        try
        {

            ClassLoader classLoader = getClass().getClassLoader();
            input = classLoader.getResourceAsStream("postgresql.properties");
            prop.load(input);

            Class.forName(prop.getProperty("driver"));
            String url = "jdbc:" + prop.getProperty("engine") +
                    "://" + prop.getProperty("hostname") +
                    ":" + prop.getProperty("port") +
                    "/" + prop.getProperty("database");
            conn = DriverManager.getConnection(
                    url,
                    prop.getProperty("user"),
                    prop.getProperty("password")
            );

            log.info("#### Read Postgresql config from file");

            return true;

        } catch (SQLException | ClassNotFoundException exc) {

            log.log(Level.SEVERE, "Failed PostgreSQL DB connection", exc);
            exc.printStackTrace();
            return false;

        } catch (java.io.IOException exc) {

            log.log(Level.SEVERE, "Failed to read PostgreSQL configuration from file", exc);
            exc.printStackTrace();
            return false;

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (java.io.IOException exc) {
                    log.log(Level.SEVERE, "Failed to close properties file", exc);
                    exc.printStackTrace();
                }
            }
        }
    }

    /**
     * Closes the connection to the Fact-Extraction PostgreSQL database.
     *
     * @param rs SQL ResultSet to close
     * @param s SQL Statement to close
     * @param c SQL Connection to close
     */
    private void finalise(ResultSet rs, Statement s, Connection c) {
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
    // This is replicated and extended in the following function
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
        Statement statement = null;
        ResultSet resultSet = null;

        List<Tweet> tweetList = new ArrayList<>();

        try {
            if (!connect()) { return null; }

            // Build up the SQL query using a subquery for each topic - allows consistency
            // May as well do it in one pass without PreparedQuery since we need to convert bool3 anyway
            StringBuilder queryString = new StringBuilder(
                    // Get the tables we want data from
                    "SELECT DISTINCT ON (extract.item_key) " +
                    "extract.item_key, extract.extract, extract.source_uri, post.text, post.created_at " +
                    "FROM factextract.phase1_ext_db_item as extract " +
                    "JOIN factextract.phase1_ext_db_topic_index as topic_index " +
                    "ON (extract.item_key = topic_index.item_key) " +
                    "LEFT JOIN factextract.phase1_post_db_item as post " +
                    "ON (extract.source_uri = post.source_uri) "
            );

            for (int i=0; i < topicList.size(); i++) {
                Topic topic = topicList.get(i);

                if (i == 0) {
                    queryString.append("WHERE extract.item_key IN ");
                } else {
                    queryString.append("AND extract.item_key IN ");
                }
                queryString.append(
                        // Subquery to get a list of extract.item_key for each Topic
                        "( " +
                            "SELECT DISTINCT topic_index.item_key " +
                            "FROM factextract.phase1_ext_db_topic as topic " +
                            "JOIN factextract.phase1_ext_db_topic_index as topic_index " +
                            "ON (topic.topic_key = topic_index.topic_key) " +
                            "WHERE topic.topic = '" + topic.getName() + "' " +
                            // Database column has three states in a BOOLEAN
                            // Simpler to do this than try to use a prepared query
                            "AND topic.negated IS " + getStringRepOfBool3(topic.isNegated()) + " " +
                            "AND topic.genuine IS " + getStringRepOfBool3(topic.isGenuine()) + " " +
                        ") "
                );
            }
            queryString.append("ORDER BY extract.item_key;");

            statement = conn.createStatement();
            resultSet = statement.executeQuery(queryString.toString());

            while (resultSet.next()) {
                int id = resultSet.getInt("item_key");
                String extract = resultSet.getString("extract");
                String uri = resultSet.getString("source_uri");
                String text = resultSet.getString("text");
                java.sql.Timestamp created = resultSet.getTimestamp("created_at");

                tweetList.add(new Tweet(id, extract, uri, text, created));
            }

        } catch (SQLException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB query", exc);
            exc.printStackTrace();
            return null;
        } finally {
            finalise(resultSet, statement, conn);
        }

        return tweetList;
    }

    /**
     * Get and convert a boolean value that may be NULL (termed here a Bool3).
     * Value is converted to an int using:
     *  TRUE  ->  1
     *  FALSE ->  0
     *  NULL  -> -1
     *
     * @param resultSet SQL query ResultSet from which to get data
     * @param column Boolean column to get
     * @return Boolean value as an integer
     * @throws SQLException If column is missing
     */
    private static int getIntFromBool3(ResultSet resultSet, String column)
            throws SQLException {
        boolean bValue = resultSet.getBoolean(column);
        return resultSet.wasNull() ? -1 : (bValue ? 1 : 0);
    }

    /**
     * Get the String representation of a Bool3.
     * Values:
     *   1 -> "TRUE"
     *   0 -> "FALSE"
     *  -1 -> "NULL"
     *
     * @param bool3 Integer representation of a Bool3 {-1, 0, 1}
     * @return String representation of a Bool3
     */
    private static String getStringRepOfBool3(int bool3) {
        if (bool3 == 0) {
            return "FALSE";
        } else if (bool3 == 1) {
            return "TRUE";
        } else {
            return "NULL";
        }
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
                    "FROM factextract.phase1_ext_db_topic " +
                    "ORDER BY topic_key;";

            statement = conn.createStatement();
            resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                String topicName = resultSet.getString("topic");
                int negated = getIntFromBool3(resultSet, "negated");
                int genuine = getIntFromBool3(resultSet, "genuine");

                topicList.add(new Topic(topicName, negated, genuine));
            }

        } catch (SQLException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB query", exc);
            exc.printStackTrace();
            return null;
        } finally {
            finalise(resultSet, statement, conn);
        }

        return topicList;
    }

    /**
     * Get the list of all known VocabularyTopics.
     *
     * @return List of all VocabularyTopics present in database
     *
     * @see VocabularyTopic
     * @see Topic
     */
    public List<VocabularyTopic> listVocab() {
        Statement statement = null;
        ResultSet resultSet = null;

        Map<String, VocabularyTopic> keywordMap = new LinkedHashMap<>();

        try {
            if (!connect()) { return null; }

            String queryString =
                    "SELECT topic.topic, topic.schema " +
                    "FROM factextract.vocab_topic as topic " +
                    "ORDER BY topic.topic_id";

            statement = conn.createStatement();
            resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                String topicName = resultSet.getString("topic");
                String entityType = resultSet.getString("schema");

                keywordMap.put(topicName, new VocabularyTopic(topicName, entityType));
            }

            queryString =
                    "SELECT topic.topic, keyword.keyword " +
                    "FROM factextract.vocab_topic as topic " +
                    "JOIN factextract.vocab_keyword as keyword " +
                    "ON (topic.topic_id = keyword.topic_id);";

            resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                String topicName = resultSet.getString("topic");
                String keyword = resultSet.getString("keyword");

                keywordMap.get(topicName).addKeyword(keyword);
            }

        } catch (SQLException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB query", exc);
            exc.printStackTrace();
            return null;
        } finally {
            finalise(resultSet, statement, conn);
        }

        return new ArrayList<>(keywordMap.values());
    }

    public class AlreadyExistsException extends Exception {
        public AlreadyExistsException(String message) {
            super(message);
        }
    }

    public void addVocab(VocabularyTopic topic) {
        PreparedStatement statement = null;

        try {
            if (!connect()) return;

            String queryString =
                    "INSERT INTO factextract.vocab_topic (topic, schema) " +
                    "VALUES (?, ?) " +
                    "ON CONFLICT DO NOTHING;";

            statement = conn.prepareStatement(queryString);
            statement.setString(1, topic.getTopic());
            statement.setString(2, topic.getSchema());
            statement.execute();

            queryString =
                    "INSERT INTO factextract.vocab_keyword (topic_id, keyword) " +
                    "VALUES ((SELECT topic_id FROM factextract.vocab_topic WHERE topic = ?), ?) " +
                    "ON CONFLICT DO NOTHING ;";

            statement = conn.prepareStatement(queryString);
            for (String keyword : topic.getKeywords()) {
                statement.setString(1, topic.getTopic());
                statement.setString(2, keyword);
                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB query", exc);
            exc.printStackTrace();
        } finally {
            finalise(null, statement, conn);
        }
    }

    public void deleteVocabTopic(String vocabTopicName) {
        PreparedStatement statement = null;

        try {
            if (!connect()) return;

            // Then delete topic - database is setup to cascade
            String queryString = "DELETE FROM factextract.vocab_topic WHERE topic = ?;";
            statement = conn.prepareStatement(queryString);
            statement.setString(1, vocabTopicName);
            statement.execute();

        } catch (SQLException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB delete", exc);
            exc.printStackTrace();
        } finally {
            finalise(null, statement, conn);
        }
    }

    public void deleteVocabKeyword(String vocabTopicName, String vocabKeyword) {
        PreparedStatement statement = null;

        try {
            if (!connect()) return;

            // Delete keyword
            String queryString =
                    "DELETE FROM factextract.vocab_keyword " +
                    "WHERE topic_id IN (SELECT topic_id FROM factextract.vocab_topic WHERE topic = ?)" +
                    "AND keyword = ?;";
            statement = conn.prepareStatement(queryString);
            statement.setString(1, vocabTopicName);
            statement.setString(2, vocabKeyword);
            statement.execute();

        } catch (SQLException exc) {
            log.log(Level.SEVERE, "Failed PostgreSQL DB delete", exc);
            exc.printStackTrace();
        } finally {
            finalise(null, statement, conn);
        }
    }
}
