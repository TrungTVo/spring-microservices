package com.example.paymentservice.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentservice.services.PaymentService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("payment")
public class PaymentController {

	private final PaymentService paymentService;

	PaymentController(@Qualifier("paymentServiceImpl") PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping
	public Mono<ResponseEntity<String>> makePayment() {
		return this.paymentService.makePayment().map(ResponseEntity::ok);
	}

}
