package com.github.fhgrings.rxNetty.Config;

import com.github.fhgrings.rxNetty.Operations.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan (basePackages = "Operations.Calculator")

public class AppConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
