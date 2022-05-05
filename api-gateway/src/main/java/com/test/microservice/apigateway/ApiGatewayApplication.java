package com.test.microservice.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

//	http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR
//	http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
