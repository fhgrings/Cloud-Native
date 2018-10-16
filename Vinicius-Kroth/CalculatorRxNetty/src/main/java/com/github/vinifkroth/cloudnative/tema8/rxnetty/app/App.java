package com.github.vinifkroth.cloudnative.tema8.rxnetty.app;

import com.github.vinifkroth.cloudnative.tema8.rxnetty.health.HealthCheckResource;

import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.health.HealthCheckHandler;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import com.github.vinifkroth.cloudnative.tema8.rxnetty.handler.RxNettyHandler;
import com.github.vinifkroth.cloudnative.tema8.rxnetty.health.HealthCheckResource;
 public class App {
	 private static final int port = 8081;
	public static void main(String[] args) {
		System.setProperty("java.awt.headless","true");
		
		HealthCheckHandler healthCheckHandler = new HealthCheckResource();
        Karyon.forRequestHandler(port,
                new RxNettyHandler("/healthcheck",
                new HealthCheckEndpoint(healthCheckHandler)),
                new KaryonBootstrapModule(healthCheckHandler),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();
	}
}