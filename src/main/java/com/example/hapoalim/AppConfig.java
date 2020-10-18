package com.example.hapoalim;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public IFibonacciRepository fibonacciRepository() {
		return new IFibonacciRepository(fibonacciCalculator());
	}
	
	@Bean
	public IFibonacciCalculator fibonacciCalculator() {
		return new IFibonacciCalculator();
	}
	
}
