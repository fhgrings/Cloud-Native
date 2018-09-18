package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.vinifkroth.cloudnative.tema1.model.*;

@Configuration
@ComponentScan(basePackages = {"com.github.vinifkroth.cloudnative.tema1.model", "com.github.vinifkroth.cloudnative.tema1.service"})
public class AppConfig {

	@Bean
	public Addition addition() {
		Addition operation = new Addition();
		return operation;
	}

	@Bean
	public Subtraction subtraction() {
		Subtraction operation = new Subtraction();
		return operation;
	}

	@Bean
	public Multiplication multiplication() {
		Multiplication operation = new Multiplication();
		return operation;
	}

	@Bean
	public Division division() {
		Division operation = new Division();
		return operation;
	}

	@Bean
	public Power power() {
		Power operation = new Power();
		return operation;
	}
	
}
