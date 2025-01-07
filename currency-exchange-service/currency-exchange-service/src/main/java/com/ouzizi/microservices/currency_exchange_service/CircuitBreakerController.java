package com.ouzizi.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
public class CircuitBreakerController {
	private Logger logger = 
			LoggerFactory.getLogger(CircuitBreakerController.class);
	@GetMapping("/sample-api")
	public String sampleApi() {
		logger.info("Sample api call received");
		//ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
			//		String.class);
//		return forEntity.getBody();
		return "sample-api";
	}
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
}
