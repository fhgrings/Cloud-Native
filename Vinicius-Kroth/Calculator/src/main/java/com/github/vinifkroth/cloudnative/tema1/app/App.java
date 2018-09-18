package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.vinifkroth.cloudnative.tema1.model.*;
import com.github.vinifkroth.cloudnative.tema1.service.Calculator;

public class App {

	public static void main(String args[]) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Addition addition = (Addition) appContext.getBean("addition");
		Subtraction subtraction = (Subtraction) appContext.getBean("subtraction");
		Power power = (Power) appContext.getBean("power");
		Division division = (Division) appContext.getBean("division");
		Multiplication multiplication = (Multiplication) appContext.getBean("multiplication");

		Calculator calculator = new Calculator(addition, subtraction, multiplication, division, power);
		System.out.println(calculator.add(0.1, 0.2));
		System.out.println(calculator.divide(10, 20));
		System.out.println(calculator.power(2, 10));
		System.out.println(calculator.multiplicate(2, 4.5));
		System.out.println(calculator.subtract(3.3, 2.1));
		System.out.println(calculator.showRecord());
		
		System.out.println(calculator.add(0.1, 0.2));
		System.out.println(calculator.divide(10, 20));
		System.out.println(calculator.power(2, 10));
		System.out.println(calculator.multiplicate(2, 4.1));
		System.out.println(calculator.subtract(3.5, 2.1));
		
		((AnnotationConfigApplicationContext) appContext).close();
	}
}
