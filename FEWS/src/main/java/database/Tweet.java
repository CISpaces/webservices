package database;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"id", "extract", "uri", "text"})
public class Tweet {

    private int id;
    private String extract;
    private String uri;
    private String text;

    public Tweet(int id, String extract, String uri, String text) {
        this.id = id;
        this.extract = extract;
        this.uri = uri;
        this.text = text;
    }

    public Tweet(int id, String extract, String uri) {
        this.id = id;
        this.extract = extract;
        this.uri = uri;
        this.text = "";
    }

    public int getId() {
        return id;
    }

    public String getExtract() {
        return extract;
    }

    public String getUri() {
        return uri;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", extract='" + extract + '\'' +
                ", uri='" + uri + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
