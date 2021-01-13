package com.example.schoolservice.controller;

import java.net.URI;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SchoolController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("obtain_greetMsg")
	public ResponseEntity<?> obtainGreetMsg() throws ServiceUnavailableException {
		URI service = discoveryClient.getInstances("student-service")
			.stream()
			.findFirst()
			.map(serviceInstance -> serviceInstance.getUri())
			.map(s -> s.resolve("/greet_student"))
			.get();
		
		ResponseEntity<String> res = restTemplate.getForEntity(service, String.class);
		ResponseEntity<String> msgRes = ResponseEntity.status(HttpStatus.OK).body("Message from student-service: " + res.getBody());
		return msgRes;
	}
}
