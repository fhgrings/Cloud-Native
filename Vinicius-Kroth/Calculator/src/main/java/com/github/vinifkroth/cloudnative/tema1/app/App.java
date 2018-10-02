package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.github.vinifkroth.cloudnative.tema1.model.Operation;
import com.github.vinifkroth.cloudnative.tema1.service.Calculator;

public class App {

	public static void main(String args[]) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Calculator calculator = (Calculator) appContext.getBean("calculator");
		try {
			System.out.println(calculator.calculate(2, 5, "/"));
			System.out.println(calculator.calculate(10, 5, "^"));
			System.out.println(calculator.calculate(-10, -25, "*"));
			System.out.println(calculator.calculate(30, 10, "-"));
			System.out.println(calculator.calculate(500, 100, "+"));
			System.out.println(calculator.calculate(100, 2, "^"));

			System.out.println("Histórico de resultados:");
			for (Operation operation : calculator.getResultsRecord()) {
				System.out.println(operation.calculate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		((AnnotationConfigApplicationContext) appContext).close();
	}
}
