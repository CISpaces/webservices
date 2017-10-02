package messagebus;

public class ControlMessage {

    private String topic;
    private boolean remove;

    public ControlMessage(String topic) {
        this(topic, false);
    }

    public ControlMessage(String topic, boolean remove) {
        this.topic = topic;
        this.remove = remove;
    }

    public String serialize() {
        return "{\"name\": \"" + topic + "\", " +
                "\"remove\": " + remove + "}";
    }
}
