package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrokerTest {
    private Broker broker;
    private Producer producer;
    private Consumer consumer;

    @BeforeEach
    void setUp() {
        broker = new Broker();
        producer = new Producer(broker);
        consumer = new Consumer(broker);
        broker.createTopic("test-topic");
    }

    @Test
    void testPublishAndConsumeMessage() {
        // Producer sends a message to the topic
        producer.sendMessage("test-topic", "Test Message");
        
        // Consumer tries to consume the message
        String message = consumer.consumeMessage("test-topic");

        // Assert the message consumed is the same as the one sent
        assertEquals("Test Message", message, "Message should match the one sent by producer.");
    }

    @Test
    void testConsumeFromEmptyTopic() {
        // Trying to consume from an empty topic should return null
        String message = consumer.consumeMessage("test-topic");
        
        // Assert that the message is null when the topic is empty
        assertNull(message, "Should return null when topic has no messages.");
    }
}
