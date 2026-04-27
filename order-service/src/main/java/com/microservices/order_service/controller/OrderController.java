package com.microservices.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.order_service.interfaces.PaymentClient;
import com.microservices.order_service.interfaces.UserClient;

@RestController
@RequestMapping("/orders")
public class OrderController {

	// @Autowired
	// private RestTemplate restTemplate;

	@Autowired
	UserClient userClient;

	@Autowired
	PaymentClient paymentClient;

	@GetMapping
	public String createOrder() {
		/*
		 * String user = restTemplate.getForObject("http://localhost:8081/users/1",
		 * String.class);
		 * 
		 * String payment = restTemplate.postForObject("http://localhost:8083/payment",
		 * null, String.class);
		 */

		String user =  userClient.getUser(1L);
		String payment = paymentClient.doPayment();

		return "Order created for " + user + " | " + payment +"via Feign";
	}
}