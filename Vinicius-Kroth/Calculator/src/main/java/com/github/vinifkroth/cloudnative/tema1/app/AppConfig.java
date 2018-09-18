package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.vinifkroth.cloudnative.tema1.model.*;

@Configuration
@ComponentScan(basePackages = "com.github.vinifkroth.cloudnative.tema1.model")
public class AppConfig {

	@Bean
	Operation addition() {
		Operation operation = new Addition();
		return operation;
	}

	@Bean
	Operation subtraction() {
		Operation operation = new Subtraction();
		return operation;
	}

	@Bean
	Operation multiplication() {
		Operation operation = new Multiplication();
		return operation;
	}

	@Bean
	Operation division() {
		Operation operation = new Division();
		return operation;
	}

	@Bean
	Operation power() {
		Operation operation = new Power();
		return operation;
	}
}
