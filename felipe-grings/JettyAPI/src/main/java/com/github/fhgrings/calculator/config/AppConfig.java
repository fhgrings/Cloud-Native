package com.github.fhgrings.calculator.config;

import com.github.fhgrings.calculator.operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan (basePackages = "operations.Calculator")

public class AppConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
