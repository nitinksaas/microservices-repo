package com.microservices.order_service.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservices.order_service.service.PaymentFallback;

@FeignClient(name = "payment-service", url = "http://payment-service:8083", fallback = PaymentFallback.class)
public interface PaymentClient {

	@PostMapping("/payment")
	String doPayment();
}
