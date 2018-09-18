package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.vinifkroth.cloudnative.tema1.service.Calculator;

public class App {

	public static void main(String args[]) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Calculator calculator = appContext.getBean(Calculator.class);
		System.out.println(calculator.add(0.1, 0.2));
		System.out.println(calculator.divide(10, 20));
		System.out.println(calculator.power(2, 10));
		System.out.println(calculator.multiplicate(2, 4.5));
		System.out.println(calculator.subtract(3.3, 2.1));
		System.out.println(calculator.showRecord());

		System.out.println(calculator.add(0.1, 0.2));
		System.out.println(calculator.divide(220, 20));
		System.out.println(calculator.power(3, 10));
		System.out.println(calculator.multiplicate(2, 4.1));
		System.out.println(calculator.subtract(3.5, 2.1));
		System.out.println(calculator.showRecord());

		((AnnotationConfigApplicationContext) appContext).close();
	}
}
