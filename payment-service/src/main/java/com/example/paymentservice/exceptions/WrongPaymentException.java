package com.example.paymentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WrongPaymentException extends RuntimeException {
		
	protected static final String DEFAULT_MESSAGE = "Something wrong while making payment!";
	
	public WrongPaymentException() {
		super(DEFAULT_MESSAGE);
	}
	
	public WrongPaymentException(String message) {
		super(message);
	}
	
	public WrongPaymentException(String message, Throwable cause) {
		super(message, cause);
	}
}
