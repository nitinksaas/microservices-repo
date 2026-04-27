package com.microservices.order_service.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://user-service:8081")
public interface UserClient {

	@GetMapping("/users/{id}")
	String getUser(@PathVariable("id") Long id);

}
