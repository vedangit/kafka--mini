package com.mycompany.app;

public class Producer {
    private final Broker broker;

    public Producer(Broker broker) {
        this.broker = broker;
    }

    public void sendMessage(String topicName, String message) {
        broker.publish(topicName, message);
    }
}
