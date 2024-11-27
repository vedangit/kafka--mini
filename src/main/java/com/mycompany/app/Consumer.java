package com.mycompany.app;
/**
 * Consumer class is responsible for consuming messages from a specific topic in the broker.
 * It interacts with the Broker class to fetch messages. (SUBSCRIBER)
 */
public class Consumer {
    private final Broker broker;

    
    /**
     * Constructor to initialize the Consumer with a Broker instance.
     * 
     * @param broker The Broker that this Consumer will interact with.
     */

    public Consumer(Broker broker) {
        this.broker = broker;
    }

    /**
     * Consumes a message from the specified topic.
     * basically subscribing to a topic sort of
     * @param topicName The name of the topic.
     * @return The consumed message, or null if the topic is empty.
     */
    public String consumeMessage(String topicName) {
        return broker.consume(topicName);
    }
}
