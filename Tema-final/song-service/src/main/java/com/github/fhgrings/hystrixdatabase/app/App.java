package com.github.fhgrings.hystrixdatabase.app;

import com.github.fhgrings.hystrixdatabase.service.EurekaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.github.fhgrings.hystrixdatabase")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        EurekaService service = EurekaService.getInstance();
        String appID = "song-service";
        System.out.println(service.post(appID));
        System.out.println(service.get(appID));

    }
}