package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Broker.
 */
public class BrokerTest {
    
    private Broker broker;

    @BeforeEach
    public void setUp() {
        broker = new Broker();
        broker.createTopic("test-topic");  // Create a topic before running tests
    }

    @Test
    public void testPublishAndConsume() {
        // Publish a message
        String message = "Test Message";
        broker.publish("test-topic", message);

        // Consumer consumes the message
        String consumedMessage = broker.consume("test-topic");

        // Verify that the consumer gets the same message
        assertEquals(message, consumedMessage, "Consumer should consume the correct message");
    }

    @Test
    public void testConsumeEmptyTopic() {
        // Try to consume from an empty topic
        String consumedMessage = broker.consume("test-topic");

        // Verify that the message is null since no message is available
        assertNull(consumedMessage, "Consumer should return null when the topic is empty");
    }

    @Test
    public void testContinuousStream() throws InterruptedException {
        // Produce several messages
        for (int i = 0; i < 10; i++) {
            broker.publish("test-topic", "Message " + i);
        }

        // Allow the consumer time to consume all the messages (5 seconds max)
        long startTime = System.currentTimeMillis();
        boolean allConsumed = true;

        for (int i = 0; i < 10; i++) {
            String message = broker.consume("test-topic");
            if (message == null || !message.equals("Message " + i)) {
                allConsumed = false;
                break;
            }
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        // Ensure that all messages are consumed within 5 seconds
        assertTrue(allConsumed, "Consumer should consume all messages within 5 seconds");
        assertTrue(elapsedTime <= 5000, "Consumer took more than 5 seconds to consume all messages");
    }
}
