package com.github.rafaritter44.cloud_native.jetty.app.config;

import com.github.rafaritter44.cloud_native.jetty.app.Calculadora;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.github.rafaritter44.cloud_native.calculadora")
public class AppConfig {

    @Bean
    public Calculadora calculadora() {
        return new Calculadora();
    }

}
