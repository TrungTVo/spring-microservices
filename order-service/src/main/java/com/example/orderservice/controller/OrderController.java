package com.example.orderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("order")
public class OrderController {

	final WebClient.Builder webClientBuilder;

	OrderController(WebClient.Builder webClientBuilder) {
		this.webClientBuilder = webClientBuilder;
	}

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
