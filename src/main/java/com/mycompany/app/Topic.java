package com.mycompany.app;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * Topic class represents a specific topic in the broker.
 * It stores messages in a thread-safe manner using a ConcurrentLinkedQueue.
 */
public class Topic {
    private final String name;
    private final Queue<String> messages;

    public Topic(String name) {
        this.name = name;
        this.messages = new ConcurrentLinkedQueue<>();
    }

    public String getName() {
        return name;
    }

    public void publishMessage(String message) {
        messages.add(message);
    }

    public String consumeMessage() {
        return messages.poll();
    }

    public boolean isEmpty() {
        return messages.isEmpty();
    }
}
