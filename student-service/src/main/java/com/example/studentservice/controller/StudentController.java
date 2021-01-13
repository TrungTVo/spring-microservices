package com.example.studentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("greet_student")
	public ResponseEntity<?> greetStudent() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello from student service!");
	}

}
