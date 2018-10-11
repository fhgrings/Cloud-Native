package com.github.rafaritter44.cloud_native.rxnetty;

import com.github.rafaritter44.cloud_native.rxnetty.handler.RxNettyHandler;
import com.github.rafaritter44.cloud_native.rxnetty.health.HealthCheck;

import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;

public class AppRunner {
	public static void main(String[] args) {
        HealthCheck healthCheckHandler = new HealthCheck();
        Karyon.forRequestHandler(8888,
                new RxNettyHandler("/healthcheck",
                        new HealthCheckEndpoint(healthCheckHandler)),
                new KaryonBootstrapModule(healthCheckHandler),
                new ArchaiusBootstrapModule("hello-netflix-oss"),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();
	}
}
