package com.example.paymentservice.services;

import reactor.core.publisher.Mono;

public interface PaymentService {
    Mono<String> makePayment();
}
