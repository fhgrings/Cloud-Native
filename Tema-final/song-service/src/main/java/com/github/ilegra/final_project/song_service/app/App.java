package com.github.ilegra.final_project.song_service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.github.fhgrings.song_service")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}