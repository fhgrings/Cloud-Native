package com.github.fhgrings.calculator.Config;

import com.github.fhgrings.calculator.Map.*;
import com.github.fhgrings.calculator.Operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = "Operations.Calculator")

public class AppConfig {
    @Bean
    public MapOperations mapOperationsConfig() {
        MapOperations map = new MapOperations();
        map.getMapOperation().put("+", new Sum());
        map.getMapOperation().put("-", new Subtraction());
        map.getMapOperation().put("*", new Multiply());
        map.getMapOperation().put("/", new Division());
        map.getMapOperation().put("^", new Pow());

        return map;
    }

    @Bean
    public MapHistoryCalculator mapHistoryCalculatorConfig() {
        MapHistoryCalculator mapHistoryCalculator = new MapHistoryCalculator();
        return mapHistoryCalculator;
    }

    @Bean
    public Calculator calculator() {
        Calculator calculator = new Calculator(mapOperationsConfig(), mapHistoryCalculatorConfig());
        return calculator;
    }
}
