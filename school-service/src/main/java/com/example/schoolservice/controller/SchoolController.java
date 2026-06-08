package com.example.schoolservice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class SchoolController {

	@Autowired
	WebClient.Builder webClientBuilder;

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("obtain_greetMsg")
	public Mono<ResponseEntity<String>> obtainGreetMsg() {
		URI service = discoveryClient.getInstances("student-service")
			.stream()
			.findFirst()
			.map(serviceInstance -> serviceInstance.getUri())
			.map(s -> s.resolve("/greet_student"))
			.orElseThrow(() -> new IllegalStateException("student-service not available"));

		return webClientBuilder.build()
			.get()
			.uri(service)
			.retrieve()
			.bodyToMono(String.class)
			.map(body -> ResponseEntity.ok("Message from student-service: " + body));
	}
}
