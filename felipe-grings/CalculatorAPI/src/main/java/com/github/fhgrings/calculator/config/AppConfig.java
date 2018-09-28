package com.github.fhgrings.calculator.config;

import com.github.fhgrings.calculator.map.*;
import com.github.fhgrings.calculator.operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan (basePackages = "operations.Calculator")

public class AppConfig {
    @Bean
    public MapOperations mapOperationsConfig() {
        MapOperations map = new MapOperations();
        map.getMapOperation().put("sum", Sum.class );
        map.getMapOperation().put("sub", Subtraction.class);
        map.getMapOperation().put("mult", Multiply.class);
        map.getMapOperation().put("div", Division.class);
        map.getMapOperation().put("pow", Pow.class);

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
