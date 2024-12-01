package com.mycompany.app;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Topic class represents a topic in the broker.
 * It holds a queue of messages and allows messages to be published and consumed.
 */
public class Topic {
    private final String name;
    private final Queue<String> messages = new LinkedList<>();

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void publishMessage(String message) {
        messages.offer(message);  // Add message to the queue
    }

    public String consumeMessage() {
        return messages.poll();  // Remove and return the message
    }

    public boolean isEmpty() {
        return messages.isEmpty();  // Check if there are no messages
    }
}
