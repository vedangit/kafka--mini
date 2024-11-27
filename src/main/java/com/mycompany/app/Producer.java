package com.mycompany.app;
/**
 * Producer class is responsible for sending messages to a specific topic in the broker.
 * It interacts with the Broker class to publish messages to topics.
 */
public class Producer {
    private final Broker broker;

    /**
     * Constructor to initialize the Producer with a Broker instance.
     * 
     * @param broker The Broker that this Producer will interact with.
     */

    public Producer(Broker broker) {
        this.broker = broker;
    }

    
    /**
     * Sends a message to a specified topic in the broker.
     * 
     * @param topicName The name of the topic.
     * @param message The message to be sent.
     */
    public void sendMessage(String topicName, String message) {
        broker.publish(topicName, message);
    }
}
