package database;

import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * This class represents a Topic as stored in the Fact-Extraction PostgreSQL database.
 *
 * @see PostgreSQLDB
 */
@JsonbPropertyOrder({"name", "negated", "genuine"})
public class Topic {
    private String name;
    private boolean negated;
    private boolean genuine;

    /**
     * Construct a new Topic.
     *
     * @param name The Topic name - e.g. "topic unrest"
     * @param negated Whether the Topic is negated - i.e. "there is no unrest"
     * @param genuine Whether the Topic is genuine - i.e. "the report of unrest is false"
     */
    public Topic(String name, boolean negated, boolean genuine) {
        this.name = name;
        this.negated = negated;
        this.genuine = genuine;
    }

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
    public boolean isNegated() {
        return negated;
    }

    /**
     * Is the Topic genuine.
     *
     * @return Is Topic genuine
     */
    public boolean isGenuine() {
        return genuine;
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
