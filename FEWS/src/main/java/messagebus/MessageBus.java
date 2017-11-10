package messagebus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class manages sending of control messages down a RabbitMQ bus.
 */
public class MessageBus {
    private final String HOSTNAME;
    private final String EXCHANGE;
    private final String USERNAME;

    private static final ObjectWriter objectWriter = new ObjectMapper().writer();
    private static final AMQP.BasicProperties amqpProperties =
            new AMQP.BasicProperties.Builder().contentType("application/json").build();

    private final ConnectionFactory connectionFactory = new ConnectionFactory();
    private Connection connection = null;
    private Channel channel = null;
    private static Logger log;

    /**
     * Construct a new MessageBus pointing to a RabbitMQ server defined in 'rabbitmq.properties'.
     */
    public MessageBus() {
        log = Logger.getLogger(getClass().getName());

        final Properties prop = new Properties();
        InputStream input = null;

        try {
            final ClassLoader classLoader = getClass().getClassLoader();
            input = classLoader.getResourceAsStream("rabbitmq.properties");
            prop.load(input);

        } catch (IOException exc) {
            log.log(Level.SEVERE, "Failed to read properties file", exc);
            exc.printStackTrace();

        } finally {
            HOSTNAME = prop.getProperty("hostname", null);
            EXCHANGE = prop.getProperty("exchange", null);
            USERNAME = prop.getProperty("username", null);
            final String password = prop.getProperty("password", null);

            if (HOSTNAME != null) connectionFactory.setHost(HOSTNAME);
            if (USERNAME != null) connectionFactory.setUsername(USERNAME);
            if (password != null) connectionFactory.setPassword(password);

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
     * Connect to the RabbitMQ server.
     *
     * Define a 'fanout' (pub/sub) exchange.
     *
     * @return Was the connection successful?
     */
    private boolean connect() {
        if (HOSTNAME == null || EXCHANGE == null) return false;
        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE, "fanout");
            return true;

        } catch (java.io.IOException | java.util.concurrent.TimeoutException exc) {
            log.log(Level.SEVERE, "Failed RabbitMQ message bus connection", exc);
            exc.printStackTrace();
            return false;
        }
    }

    /**
     * Close the connection to the RabbitMQ server.
     */
    private void finalise() {
        try {
            channel.close();
        } catch (java.io.IOException | java.util.concurrent.TimeoutException exc) { /* Nothing */ }
        try {
            connection.close();
        } catch (java.io.IOException exc) { /* Nothing */ }
    }

    /**
     * Send an Object down the RabbitMQ bus as JSON.
     *
     * @param object Object to send
     * @return Was sending successful?
     */
    public boolean send(Object object) {
        if (!connect()) { return false; }

        try {
            channel.basicPublish(EXCHANGE, "", amqpProperties, objectWriter.writeValueAsBytes(object));
            return true;

        } catch (java.io.IOException exc) {
            log.log(Level.SEVERE, "Failed to send RabbitMQ message", exc);
            exc.printStackTrace();
            return false;

        } finally {
            finalise();
        }
    }
}
