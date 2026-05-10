package com.microservices.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.payment_service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
    @PostMapping("/payment")
    public String doPayment() {
        return "Payment Success !!!";
    }
    
    @PostMapping("/process")
    public String doPaymentProcess() {
        return paymentService.getCardType();
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }	
}