package com.github.fhgrings.calculator.Config;

import com.github.fhgrings.calculator.Map.*;
import com.github.fhgrings.calculator.Operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan (basePackages = "Operations.Calculator")

public class AppConfig {
    @Bean
    public MapOperations mapOperationsConfig() {
        MapOperations map = new MapOperations();
        map.getMapOperation().put("+", Sum.class );
        map.getMapOperation().put("-", Subtraction.class);
        map.getMapOperation().put("*", Multiply.class);
        map.getMapOperation().put("/", Division.class);
        map.getMapOperation().put("^", Pow.class);

        return map;
    }

    @Bean
    public ListHistoryCalculator mapHistoryCalculatorConfig() {
        ListHistoryCalculator mapHistoryCalculator = new ListHistoryCalculator();
        return mapHistoryCalculator;
    }

    @Bean
    public Calculator calculator() {
        Calculator calculator = new Calculator(mapOperationsConfig(), mapHistoryCalculatorConfig());
        return calculator;
    }
}
