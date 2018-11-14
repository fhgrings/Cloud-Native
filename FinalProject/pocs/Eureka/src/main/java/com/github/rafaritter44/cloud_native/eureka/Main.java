package com.github.rafaritter44.cloud_native.eureka;

import com.github.rafaritter44.cloud_native.eureka.service.EurekaService;

public class Main {
	
	public static void main(String[] args) {
		EurekaService service = EurekaService.getInstance();
		String appID = "test";
		System.out.println(service.post(appID));
		System.out.println(service.get(appID));
	}
	
}