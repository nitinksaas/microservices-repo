package com.microservices.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class OrderServiceImpl {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public String createOrder() {
		String user = restTemplate.getForObject("http://localhost:8081/users/1", String.class);

		String payment = restTemplate.postForObject("http://localhost:8083/payment", null, String.class);

		return "Order created for " + user + " | " + payment;
	}
}
