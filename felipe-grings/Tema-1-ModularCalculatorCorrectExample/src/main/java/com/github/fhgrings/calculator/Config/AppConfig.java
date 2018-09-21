package com.github.fhgrings.calculator.Config;

import com.github.fhgrings.calculator.Map.*;
import com.github.fhgrings.calculator.Operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
@ComponentScan (basePackages = "Operations.Calculator")

public class AppConfig {
    double value1;
    double valule2;
    @Bean
    public MapOperations mapOperationsConfig() {
        MapOperations map = new MapOperations();
        //GESPONE gespone = new GESPONE();
        map.getMapOperation().put("+", new Sum());
        //map.getMapOperation().put("-", new Subtraction());
        //map.getMapOperation().put("*", new Multiply());
       // map.getMapOperation().put("/", gespone.division();
        //map.getMapOperation().put("^", new Pow());

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
