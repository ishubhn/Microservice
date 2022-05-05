package com.test.microservice.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name = "default")
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse") //Custom retry method, properties in property file
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//	@RateLimiter(name = "default")	// Ex. limit the no of calls to api in certain time duration
	@Bulkhead(name = "default") // Concurrent calls
	public String sampleApi() {
		logger.info("Sample API call recieved");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
				String.class);
		
		return forEntity.getBody();
	}
	
	public String hardcodedResponse(Exception e) {
//		return "fallback-response";
		return "An error occured";
	}
}
