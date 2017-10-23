package database;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.util.*;

/**
 * This class represents a plain topic with associated keywords.
 * It does not have associated 'negated' or 'genuine' since it is used only for
 * passing a list of categorised keywords to the fact-extraction Python service.
 *
 * These define the vocabulary which fact-extraction will parse.
 * The class Topic is then part of the output of fact-extraction.
 *
 * @see PostgreSQLDB
 * @see Topic
 */
@JsonbPropertyOrder({"topic", "schema", "keywords"})
public class VocabularyTopic {
    private String topic;
    private String schema;
    private ArrayList<String> keywords;

    /**
     * Default constructor required for transparent JSON handling
     */
    public VocabularyTopic() {}

    public VocabularyTopic(String topic, String schema) {
        this(topic, schema, new ArrayList<>());
    }

    public VocabularyTopic(String topic, String schema, ArrayList<String> keywords) {
        this.topic = topic;
        this.schema = schema;
        this.keywords = keywords;
    }

    public String getTopic() {
        return topic;
    }

    public String getSchema() {
        return schema;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public void addKeyword(String keyword) {
        this.keywords.add(keyword);
    }

    public static Map<String, Map<String, List<String>>> asControlMessage(List<VocabularyTopic> vocabularyTopicList) {
        // Set up data structure that fact-extraction requires
        Map<String, Map<String, List<String>>> message = new LinkedHashMap<>();
        message.put("lexicon", new LinkedHashMap<>());
        message.put("phrase_mapping", new LinkedHashMap<>());

        // Populate it
        for (VocabularyTopic topic : vocabularyTopicList) {
            message.get("lexicon").put(topic.topic, Collections.singletonList(topic.schema));

            for (String keyword : topic.getKeywords()) {
                message.get("phrase_mapping").put(keyword, Collections.singletonList(topic.topic));
            }
        }

        return message;
    }
}
