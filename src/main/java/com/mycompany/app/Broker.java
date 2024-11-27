package com.mycompany.app;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Broker class acts as the message broker, managing multiple topics.
 * It allows producers to publish messages to topics and consumers to consume messages from them.
 */

public class Broker {
    private final ConcurrentMap<String, Topic> topics = new ConcurrentHashMap<>();


    /**
     * Creates a topic if it doesn't already exist.
     * 
     * @param topicName The name of the topic to be created.
     */

    public void createTopic(String topicName) {
        topics.putIfAbsent(topicName, new Topic(topicName));
    }


    /**
     * Publishes a message to the specified topic.
     * 
     * @param topicName The name of the topic.
     * @param message The message to be published.
     */

    public void publish(String topicName, String message) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.publishMessage(message);
        }
    }


    /**
     * Consumes a message from the specified topic.
     * 
     * @param topicName The name of the topic.
     * @return The consumed message, or null if the topic is empty.
     */
    
    public String consume(String topicName) {
        Topic topic = topics.get(topicName);
        if (topic != null && !topic.isEmpty()) {
            return topic.consumeMessage();
        }
        return null;
    }
}
