package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.vinifkroth.cloudnative.tema1.service.CalculatorService;

@Configuration
@ComponentScan(basePackages= "com.github.vinifkroth.cloudnative.tema1.model")
public class AppConfig {

	@Bean
	public CalculatorService calculatorService(double firstNumber, double secondNumber) {
		CalculatorService calculator= new CalculatorService();
		calculator.setFirstNumber(firstNumber);
		calculator.setSecondNumber(secondNumber);
		return calculator;
	}
}
