package com.microservices.payment_service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content; // ✅ CORRECT
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//@MockBean
	//PaymentService paymentService;

	@Test
	void contextLoads() {
	}

	@Test
	void testPaymentCall() throws Exception {

		mockMvc.perform(post("/payment")).andExpect(status().isOk())
				.andExpect((ResultMatcher) content().string("Payment Success"));

		// assertNotNull(paymentStatus);

		// assertEquals(paymentStatus, "Payment Success");

	}

	@Test
	void testPaymentProcess() throws Exception {

	        // ✅ Proper mocking
	        //when(paymentService.getCardType()).thenReturn("UPI");

	        mockMvc.perform(post("/payment/process"))
            .andExpect(status().isOk())
            .andExpect(content().string("UPI"));
	    }
}
