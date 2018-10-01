package com.github.fhgrings.calculator.Config;

import com.github.fhgrings.calculator.Operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan (basePackages = "Operations.Calculator")

public class AppConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
