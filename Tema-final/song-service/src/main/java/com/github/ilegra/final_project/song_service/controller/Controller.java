package com.github.ilegra.final_project.song_service.controller;

import com.github.ilegra.final_project.song_service.command.DetailSongCommand;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {


    @RequestMapping("song-eureka/songs/{id}")
    @ResponseBody
    public String detailSong (@PathVariable("id") int id) {
        HystrixCommand.Setter config = HystrixCommand
                .Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("song_service"));


        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
        commandProperties.withExecutionTimeoutInMilliseconds(5_000);
        config.andCommandPropertiesDefaults(commandProperties);

        return new DetailSongCommand(config, id).execute();

    }
}
