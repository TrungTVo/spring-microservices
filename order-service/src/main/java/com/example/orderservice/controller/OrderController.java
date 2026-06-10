package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	WebClient.Builder webClientBuilder;

	@GetMapping
	public Mono<ResponseEntity<String>> obtainGreetMsg() {
		return webClientBuilder.build()
			.get()
			.uri("http://payment-service/payment")
			.retrieve()
			.bodyToMono(String.class)
			.map(body -> ResponseEntity.ok("Message from payment-service: " + body));
	}
}
