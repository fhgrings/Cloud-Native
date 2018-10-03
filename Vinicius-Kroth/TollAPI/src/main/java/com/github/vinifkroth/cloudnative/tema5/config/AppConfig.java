package com.github.vinifkroth.cloudnative.tema5.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.vinifkroth.cloudnative.tema5.service.TollService;

@Configuration
@ComponentScan(basePackages = { "com.github.vinifkroth.cloudnative.tema1.service" })
public class AppConfig {
	@Bean
	public TollService tollService() {
		return new TollService();
	}
}
