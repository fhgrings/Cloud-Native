package com.github.vinifkroth.cloudnative.tema12.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication(scanBasePackages = "com.github.vinifkroth.cloudnative.tema12")
public class HelloWorldApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApiApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void notifyApplicationStart() {
		System.out.println("The springboot application has started sucesfully!");
	}

	@EventListener(ApplicationFailedEvent.class)
	public void notifyApplicationStop() {
		System.out.println("The springboot application has failed to start!");
	}
}
