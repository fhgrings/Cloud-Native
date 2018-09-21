package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.vinifkroth.cloudnative.tema1.model.Operation;
import com.github.vinifkroth.cloudnative.tema1.service.Calculator;

public class App {

	public static void main(String args[]) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Calculator calculator = appContext.getBean(Calculator.class);
		try {
			System.out.println(calculator.calculate(2, 5, "/"));
			System.out.println(calculator.calculate(10, 5, "^"));
			System.out.println(calculator.calculate(-10, -25, "*"));
			System.out.println(calculator.calculate(30, 10, "-"));
			System.out.println(calculator.calculate(500, 100, "+"));

			System.out.println("Histórico de resultados:");
			for (Operation operation : calculator.showRecord()) {
				System.out.println(operation.calculate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		((AnnotationConfigApplicationContext) appContext).close();
	}
}
