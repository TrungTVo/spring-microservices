package com.example.accountservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {
	
	@GetMapping
	public ResponseEntity<?> greetAccount() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello from account-service!");
	}

}
