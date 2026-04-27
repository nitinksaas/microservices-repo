package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerTestAppApplication {

	@GetMapping("/message")
	private String getMessage() {
		return "docker runnig...";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerTestAppApplication.class, args);
	}

}
