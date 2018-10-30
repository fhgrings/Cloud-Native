package com.github.ilegra.final_project.playlist_service.eureka;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EurekaRegistry {
	private EurekaConfiguration config;
	private static final String APP_ID = "playlist-service";
	private static final String APP_INSTANCE = "playlist-service";

	@EventListener(ApplicationStartedEvent.class)
	public void registry() {
		config = EurekaConfiguration.getInstance();
		System.out.println(config.post(APP_ID));
	}

	@Scheduled(fixedRate = 20000, initialDelay = 5000)
	public void renewLease() {
		config = EurekaConfiguration.getInstance();
		System.out.println(config.put(APP_ID, APP_INSTANCE));
	}

}
