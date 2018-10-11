package com.github.rafaritter44.cloud_native.rxnetty.health;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

import netflix.karyon.health.HealthCheckHandler;

@Singleton
public class HealthCheck implements HealthCheckHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(HealthCheck.class);

    @PostConstruct
    public void init() {
        logger.info("Health check initialized.");
    }

    public int getStatus() {
        logger.info("Health check invoked.");
        return 200;
}

}
