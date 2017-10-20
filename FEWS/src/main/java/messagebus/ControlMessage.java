package messagebus;

import java.util.ArrayList;

public class ControlMessage {

    private String topic;
    private String entityType;
    private ArrayList<String> keywords;

    public ControlMessage(String topic, String entityType, ArrayList<String> keywords) {
        this.topic = topic;
        this.entityType = entityType;
        this.keywords = keywords;
    }

    public String serialize() {
        return "{\"name\": \"" + topic + "\", " + "}";
    }
}
