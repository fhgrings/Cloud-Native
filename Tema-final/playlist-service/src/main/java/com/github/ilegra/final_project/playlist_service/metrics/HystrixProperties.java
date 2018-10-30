package com.github.ilegra.final_project.playlist_service.metrics;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hystrix", ignoreUnknownFields = true)
class HystrixProperties {
	boolean enabled = true;
	boolean streamEnabled = false;
	String streamUrl = "/song-service/hystrix.stream";
}