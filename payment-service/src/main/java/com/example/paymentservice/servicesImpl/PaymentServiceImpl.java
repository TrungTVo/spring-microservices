package com.example.paymentservice.servicesImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.paymentservice.exceptions.WrongPaymentException;
import com.example.paymentservice.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;
import java.util.Random;

@Service
public class PaymentServiceImpl implements PaymentService {

    final WebClient.Builder webClientBuilder;
    private final Random random = new Random();
    private static final String PAYMENT_SERVICE_CB = "paymentService";

	PaymentServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClientBuilder = webClientBuilder;
	}

    @Override
    @CircuitBreaker(name = PAYMENT_SERVICE_CB, fallbackMethod = "paymentFallback")
    public Mono<String> makePayment() {
        // simulate a random failure
        if (random.nextBoolean()) {
            throw new WrongPaymentException("Something went wrong in payment-service");
        }
        return webClientBuilder.build()
			.get()
			.uri("http://notification-service/notification")
			.retrieve()
			.bodyToMono(String.class)
            .map(body -> "Hello from payment-service! Message from notification-service: " + body);
    }

    public Mono<String> paymentFallback(WrongPaymentException ex) {
        return Mono.just("This is fallback response from payment-service: " + ex.getMessage());
    }
}
