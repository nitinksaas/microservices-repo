package com.microservices.order_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.microservices.order_service.interfaces.OrderEvent;

@Service
public class KafkaProducerService {

	private static final String TOPIC = "order-events";

	
	private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

	public KafkaProducerService(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendOrderEvent(OrderEvent orderEvent) {

		kafkaTemplate.send(TOPIC, orderEvent);

		System.out.println("Order event sent: " + orderEvent.getOrderId());
	}
}