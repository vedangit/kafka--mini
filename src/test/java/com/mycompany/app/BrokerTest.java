package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests to validate the functionality of the Broker, Producer, and Consumer classes.
 */

public class BrokerTest {
    private Broker broker;
    private Producer producer;
    private Consumer consumer;
/**
     * Sets up the Broker, Producer, and Consumer instances before each test.
     */
    @BeforeEach
    void setUp() {
        broker = new Broker();
        producer = new Producer(broker);
        consumer = new Consumer(broker);
        broker.createTopic("test-topic");
    }


    /**
     * Test case to verify that a message sent by the producer is correctly consumed by the consumer.
     */
    @Test
    void testPublishAndConsumeMessage() {
        // Producer sends a message to the topic
        producer.sendMessage("test-topic", "Test Message");
        
        // Consumer tries to consume the message
        String message = consumer.consumeMessage("test-topic");

        // Assert the message consumed is the same as the one sent
        assertEquals("Test Message", message, "Message should match the one sent by producer.");
    }

    /**
     * Test case to verify that consuming from an empty topic returns null.
     */
    @Test
    void testConsumeFromEmptyTopic() {
        // Trying to consume from an empty topic should return null
        String message = consumer.consumeMessage("test-topic");
        
        // Assert that the message is null when the topic is empty
        assertNull(message, "Should return null when topic has no messages.");
    }
}
