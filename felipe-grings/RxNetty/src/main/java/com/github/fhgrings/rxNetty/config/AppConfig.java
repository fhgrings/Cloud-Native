package com.github.fhgrings.rxNetty.config;

import com.github.fhgrings.rxNetty.operations.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan (basePackages = "operations.Calculator")

public class AppConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
