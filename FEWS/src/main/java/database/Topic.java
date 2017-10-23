package database;

import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * This class represents a Topic as stored in the fact-extraction PostgreSQL database.
 * These are the output of fact-extraction, VocabularyTopics are the input.
 *
 * @see PostgreSQLDB
 * @see VocabularyTopic
 */
@JsonbPropertyOrder({"name", "negated", "genuine"})
public class Topic {
    private String name;
    private int negated;
    private int genuine;

    /**
     * Construct a new Topic.
     * A value of -1 for negated or genuine represents NULL/Unknown.
     *
     * > The 3 state for a negation Boolean is deliberate, and correct. A NULL
     * > means no mention of negation has occurred. A TRUE means negation is
     * > present. A FALSE means the grammatical extract is formulated in a way
     * > negation cannot occur (which in practice will not ever occur).
     * >
     * > The 3 state for a genuine Boolean is deliberate, and correct also. A
     * > NULL means no mention of genuine has occurred. A TRUE means a claim
     * > of being genuine is present. A FALSE means a claim of fake is
     * > present.
     *
     * @param name The Topic name - e.g. "topic unrest"
     * @param negated Whether the Topic is negated - i.e. "there is no unrest"
     * @param genuine Whether the Topic is genuine - i.e. "the report of unrest is false"
     */
    public Topic(String name, int negated, int genuine) {
        this.name = name;
        this.negated = negated;
        this.genuine = genuine;
    }

    public Topic() {}

    /**
     * Get the name of the Topic.
     *
     * @return The Topic name
     */
    public String getName() {
        return name;
    }

    /**
     * Is the Topic negated.
     *
     * @return Is Topic negated
     */
    public int isNegated() {
        return negated;
    }

    /**
     * Is the Topic genuine.
     *
     * @return Is Topic genuine
     */
    public int isGenuine() {
        return genuine;
    }

    /**
     * Set the name of the Topic.
     *
     * @param name Name of the Topic
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set whether the Topic is negated.
     * Permitted values are {-1, 0, 1}.
     * The value -1 represents NULL/Unknown.
     *
     * @param negated Is Topic negated
     */
    public void setNegated(int negated) {
        if (negated < -1 || negated > 1) { negated = -1; }
        this.negated = negated;
    }

    /**
     * Set whether the Topic is genuine.
     * Permitted values are {-1, 0, 1}.
     * The value -1 represents NULL/Unknown.
     *
     * @param genuine Is Topic genuine
     */
    public void setGenuine(int genuine) {
        if (genuine < -1 || genuine > 1) { genuine = -1; }
        this.genuine = genuine;
    }

    /**
     * Get the String representation of the Topic.
     *
     * @return String representation of Topic
     */
    @Override
    public String toString() {
        return "Topic{" +
                "entity='" + name + '\'' +
                ", negated='" + negated + '\'' +
                ", genuine='" + genuine + '\'' +
                '}';
    }
}
