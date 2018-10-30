package com.github.fhgrings.hystrixdatabase.controller;

import com.github.fhgrings.hystrixdatabase.command.SearchByPlaylist;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {


    @RequestMapping("song-service/songs/{id}")
    @ResponseBody
    public String searchPlaylist (@PathVariable("id") int id) {
        HystrixCommand.Setter config = HystrixCommand
                .Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("song_service"));


        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
        commandProperties.withExecutionTimeoutInMilliseconds(5_000);
        config.andCommandPropertiesDefaults(commandProperties);

        return new SearchByPlaylist(config, id).execute();

    }
}
