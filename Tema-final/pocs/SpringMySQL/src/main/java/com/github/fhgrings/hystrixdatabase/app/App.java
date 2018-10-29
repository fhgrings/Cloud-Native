package com.github.fhgrings.hystrixdatabase.app;

import com.github.fhgrings.hystrixdatabase.service.EurekaService;


public class App {

    public static void main(String[] args) {
        EurekaService service = EurekaService.getInstance();
        String appID = "PoC";
        System.out.println(service.post(appID));
        System.out.println(service.get(appID));
    }
}