package com.github.vinifkroth.cloudnative.tema7.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.vinifkroth.cloudnative.tema7")
public class GithubApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubApiApplication.class, args);
	}
}
