package com.example.paymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("payment")
public class PaymentController {

	final WebClient.Builder webClientBuilder;

	PaymentController(WebClient.Builder webClientBuilder) {
		this.webClientBuilder = webClientBuilder;
	}

	@GetMapping
	public Mono<ResponseEntity<String>> greetPayment() {
		return webClientBuilder.build()
			.get()
			.uri("http://notification-service/notification")
			.retrieve()
			.bodyToMono(String.class)
			.map(body -> ResponseEntity.ok("Hello from payment-service! Message from notification-service: " + body));
	}

}
