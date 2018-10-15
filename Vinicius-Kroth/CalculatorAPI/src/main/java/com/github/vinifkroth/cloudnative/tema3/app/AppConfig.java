package com.github.vinifkroth.cloudnative.tema3.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.vinifkroth.cloudnative.tema3.service.Calculator;

@Configuration
@ComponentScan(basePackages = { "com.github.vinifkroth.cloudnative.tema1.service" })
public class AppConfig {
	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
}
