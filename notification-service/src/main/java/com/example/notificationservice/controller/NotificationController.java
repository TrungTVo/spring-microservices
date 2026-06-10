package com.example.notificationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notification")
public class NotificationController {

	@GetMapping
	public ResponseEntity<?> greetNotification() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello from notification-service!");
	}

}
