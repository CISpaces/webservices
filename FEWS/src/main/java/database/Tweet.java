package database;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.util.Date;

/**
 * This class represents a Tweet as stored in the Fact-Extraction PostgreSQL database.
 *
 * @see PostgreSQLDB
 */
@JsonbPropertyOrder({"id", "extract", "uri", "text", "created"})
public class Tweet {

    private int id;
    private String extract;
    private String uri;
    private String text;
    private Date created;

    /**
     * Construct a new Tweet.
     *
     * @param id Tweet extract item_key in database
     * @param extract Extract of Tweet text
     * @param uri Twitter URI of original Tweet
     * @param text Text content of Tweet
     * @param created Time that the post was created
     */
    public Tweet(int id, String extract, String uri, String text, Date created) {
        this(id, extract, uri, text);
        this.created = created;
    }

    /**
     * Construct a new Tweet.
     *
     * @param id Tweet extract item_key in database
     * @param extract Extract of Tweet text
     * @param uri Twitter URI of original Tweet
     * @param text Text content of Tweet
     */
    public Tweet(int id, String extract, String uri, String text) {
        this(id, extract, uri);
        this.text = text;
    }

    /**
     * Construct a new Tweet.
     *
     * <p/>This constructor is to be used if no text content is present
     *
     * @param id Tweet extract item_key in database
     * @param extract Extract of Tweet text
     * @param uri Twitter URI of original Tweet
     */
    public Tweet(int id, String extract, String uri) {
        this.id = id;
        this.extract = extract;
        this.uri = uri;
        this.text = null;
        this.created = null;
    }

    /**
     * Get the Tweet extract item_key.
     *
     * @return Tweet extract item_key
     */
    public int getId() {
        return id;
    }

    /**
     * Get the Tweet extract text.
     *
     * @return Tweet extract text
     */
    public String getExtract() {
        return extract;
    }

    /**
     * Get the Tweet Twitter URI.
     *
     * @return Twitter URI of Tweet
     */
    public String getUri() {
        return uri;
    }

    /**
     * Get the text content of the Tweet.
     *
     * @return Text content of Tweet
     */
    public String getText() {
        return text;
    }

    /**
     * Get a Date timestamp of when the Tweet was posted.
     *
     * @return Timestamp of when Tweet was posted
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Get the String representation of the Tweet.
     *
     * @return String representation of Tweet
     */
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
