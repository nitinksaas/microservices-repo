package com.microservices.order_service.service;

import org.springframework.stereotype.Component;

import com.microservices.order_service.interfaces.PaymentClient;

@Component
public class PaymentFallback implements PaymentClient {

    @Override
    public String doPayment() {
        return "Payment service is down. Please try later.";
    }
}