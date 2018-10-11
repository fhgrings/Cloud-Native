package com.github.rafaritter44.cloud_native.rxnetty;

import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.health.HealthCheckHandler;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import src.main.java.com.github.rafaritter44.cloud_native.rxnetty.handler.RxNettyHandler;
import src.main.java.com.github.rafaritter44.cloud_native.rxnetty.health.HealthCheckResource;

public class AppRunner {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless","true");
		System.setProperty("archaius.deployment.environment","dev");
		
		HealthCheckHandler healthCheckHandler = new HealthCheckResource();
        Karyon.forRequestHandler(8888,
                new RxNettyHandler("/healthcheck",
                        new HealthCheckEndpoint(healthCheckHandler)),
                new KaryonBootstrapModule(healthCheckHandler),
                new ArchaiusBootstrapModule("calculator-netflix-oss"),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();
	}
}
