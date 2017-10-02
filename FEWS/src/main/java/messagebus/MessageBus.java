package messagebus;

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
    private static final String QUEUE_NAME = "factextract";

    private Connection connection = null;
    private Channel channel = null;
    private static Logger log;

    /**
     * Construct a new MessageBus pointing to a RabbitMQ server on localhost.
     *
     * @throws java.io.IOException
     * @throws java.util.concurrent.TimeoutException
     */
    public MessageBus()
            throws java.io.IOException, java.util.concurrent.TimeoutException {
        this("localhost");
    }

    /**
     * Construct a new MessageBus pointing to a RabbitMQ server on a remote host.
     *
     * @param queueHost Hostname of RabbitMQ server
     * @throws java.io.IOException
     * @throws java.util.concurrent.TimeoutException
     */
    public MessageBus(String queueHost)
            throws java.io.IOException, java.util.concurrent.TimeoutException {
        log = Logger.getLogger(getClass().getName());

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(queueHost);

        connection = factory.newConnection();
        channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    }

    /**
     * Send a message down the RabbitMQ bus.
     *
     * @param message Message to send
     * @return Was sending successful?
     */
    public boolean sendMessage(String message) {
        try {
            ControlMessage cMessage = new ControlMessage(message);
            channel.basicPublish("", QUEUE_NAME, null, cMessage.serialize().getBytes());
            return true;
        } catch (java.io.IOException exc) {
            log.log(Level.SEVERE, "Failed to send RabbitMQ message", exc);
            exc.printStackTrace();
            return false;
        }
    }

}
