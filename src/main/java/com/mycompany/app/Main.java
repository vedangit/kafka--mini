package com.mycompany.app;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kafka-mini application started.");
        
        // Example usage of broker, producer, and consumer:
        Broker broker = new Broker();
        broker.createTopic("example-topic");

        Producer producer = new Producer(broker);
        Consumer consumer = new Consumer(broker);

        producer.sendMessage("example-topic", "Hello, Kafka-mini!");
        String message = consumer.consumeMessage("example-topic");
        System.out.println("Consumed message: " + message);
    }
}
