package com.github.rafaritter44.cloud_native.rest.config;

import com.github.rafaritter44.cloud_native.rest.service.SistemaDePedagios;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.github.rafaritter44.cloud_native.rest.service")
public class AppConfig {

    @Bean
    public SistemaDePedagios sistemaDePedagios() {
        return new SistemaDePedagios();
    }

}
