package com.mycompany.app;

public class Consumer {
    private final Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }

    public String consumeMessage(String topicName) {
        return broker.consume(topicName);
    }
}
