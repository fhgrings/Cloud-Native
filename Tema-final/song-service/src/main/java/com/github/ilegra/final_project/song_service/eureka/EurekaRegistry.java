package com.github.ilegra.final_project.song_service.eureka;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaRegistry {

    @EventListener(ApplicationStartedEvent.class)
    public void resgistry(){
        EurekaService service = EurekaService.getInstance();
        String appID = "song-eureka";
        System.out.println(service.post(appID));
        System.out.println(service.get(appID));
    }
}
