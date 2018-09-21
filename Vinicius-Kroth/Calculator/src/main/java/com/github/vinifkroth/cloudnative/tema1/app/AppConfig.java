package com.github.vinifkroth.cloudnative.tema1.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.vinifkroth.cloudnative.tema1.model.Addition;
import com.github.vinifkroth.cloudnative.tema1.model.Division;
import com.github.vinifkroth.cloudnative.tema1.model.Multiplication;
import com.github.vinifkroth.cloudnative.tema1.model.Power;
import com.github.vinifkroth.cloudnative.tema1.model.Subtraction;
import com.github.vinifkroth.cloudnative.tema1.service.Calculator;

@Configuration
@ComponentScan(basePackages = { "com.github.vinifkroth.cloudnative.tema1.service" })
public class AppConfig {
	@Bean
	public Calculator calculator() {
		Calculator calculator = new Calculator();
		calculator.setResultsRecord(new ArrayList<>());
		Map map = new HashMap<String, Class>();
		map.put("+", Addition.class);
		map.put("*", Multiplication.class);
		map.put("/", Division.class);
		map.put("^", Power.class);
		map.put("-", Subtraction.class);
		calculator.setOperations(map);
		return calculator;
	}
}
