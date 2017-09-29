package database;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"name", "negated", "genuine"})
public class Topic {
    private String name;
    private boolean negated;
    private boolean genuine;

    public Topic(String name, boolean negated, boolean genuine) {
        this.name = name;
        this.negated = negated;
        this.genuine = genuine;
    }

    public String getName() {
        return name;
    }

    public boolean isNegated() {
        return negated;
    }

    public boolean isGenuine() {
        return genuine;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "entity='" + name + '\'' +
                ", negated='" + negated + '\'' +
                ", genuine='" + genuine + '\'' +
                '}';
    }
}
