package com.github.vinifkroth.cloudnative.tema1.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.github.vinifkroth.cloudnative.tema1.service" })
public class AppConfig {

}
