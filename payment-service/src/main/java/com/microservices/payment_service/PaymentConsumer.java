package com.microservices.payment_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.microservices.dto.OrderEvent;

@Service
public class PaymentConsumer {

    @KafkaListener(topics = "order-events", groupId = "order-group")
    public void consume(OrderEvent event, Acknowledgment ack) {

        try {
            System.out.println("Received Order Event: " + event);

            // 1️⃣ Idempotency check (important)
            if (isAlreadyProcessed(event.getOrderId())) {
                System.out.println("Duplicate event, skipping...");
                ack.acknowledge();
                return;
            }

            // 2️⃣ Process payment
            processPayment(event);

            // 3️⃣ Mark as processed (for idempotency)
            markAsProcessed(event.getOrderId());

            // 4️⃣ Manually commit offset
            ack.acknowledge();
            
        } catch (Exception e) {
            System.out.println("Error processing event: " + e.getMessage());

            // ❗ Do NOT acknowledge → Kafka will retry
            throw e;
        }
    }

    private void processPayment(OrderEvent event) {
        // Simulate failure for testing retry
        if (event.getPrice() > 1000) {
            throw new RuntimeException("Payment failed due to high amount");
        }

        System.out.println("Payment processed for Order: " + event.getOrderId());
    }

    private boolean isAlreadyProcessed(String orderId) {
        // TODO: Check DB or cache (Redis)
        return false;
    }

    private void markAsProcessed(String orderId) {
        // TODO: Save in DB to avoid duplicate processing
    }
}