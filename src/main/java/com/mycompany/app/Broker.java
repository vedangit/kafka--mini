package com.mycompany.app;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Broker {
    private final ConcurrentMap<String, Topic> topics = new ConcurrentHashMap<>();

    public void createTopic(String topicName) {
        topics.putIfAbsent(topicName, new Topic(topicName));
    }

    public void publish(String topicName, String message) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.publishMessage(message);
        }
    }

    public String consume(String topicName) {
        Topic topic = topics.get(topicName);
        if (topic != null && !topic.isEmpty()) {
            return topic.consumeMessage();
        }
        return null;
    }
}
