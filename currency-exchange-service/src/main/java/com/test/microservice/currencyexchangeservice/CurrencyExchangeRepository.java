package com.test.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

// To connect rest api to database
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	//	<1,2> --> Entity name, primary key
	CurrencyExchange findByFromAndTo(String from, String to); 
	
}
