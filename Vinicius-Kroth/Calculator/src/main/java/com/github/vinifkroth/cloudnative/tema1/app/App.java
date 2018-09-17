package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.vinifkroth.cloudnative.tema1.service.CalculatorService;

public class App {

	public static void main(String args[]) {
		ApplicationContext appcontext = new AnnotationConfigApplicationContext(AppConfig.class);
		CalculatorService calculator = (CalculatorService) appcontext.getBean("calculatorService", 2.2,2.2);
	}
}
