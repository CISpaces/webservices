package messagebus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class manages sending of control messages down a RabbitMQ bus.
 *
 * @see ControlMessage
 */
public class MessageBus {
    private static final String EXCHANGE_NAME = "cispaces_exchange";

    private ConnectionFactory connectionFactory = null;
    private Connection connection = null;
    private Channel channel = null;
    private static Logger log;

    /**
     * Construct a new MessageBus pointing to a RabbitMQ server on localhost.
     */
    public MessageBus() { this("localhost"); }

    /**
     * Construct a new MessageBus pointing to a RabbitMQ server on a remote host.
     *
     * @param queueHost Hostname of RabbitMQ server
     */
    public MessageBus(String queueHost) {
        log = Logger.getLogger(getClass().getName());

        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(queueHost);
    }

    /**
     * Connect to the RabbitMQ server.
     *
     * Define a 'fanout' (pub/sub) exchange.
     *
     * @return Was the connection successful?
     */
    private boolean connect() {
        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
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
     * Send a ControlMessage down the RabbitMQ bus.
     *
     * @param message Message to send
     * @return Was sending successful?
     */
    public boolean sendMessage(ControlMessage message) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            log.info(mapper.writeValueAsString(message));
        } catch (JsonProcessingException exc) {
            /* Do nothing */
        }

        if (!connect()) { return false; }
        try {
            channel.basicPublish(EXCHANGE_NAME, "", null, message.serialize().getBytes());
            finalise();
            return true;
        } catch (java.io.IOException exc) {
            log.log(Level.SEVERE, "Failed to send RabbitMQ message", exc);
            exc.printStackTrace();
            finalise();
            return false;
        }
    }
}
