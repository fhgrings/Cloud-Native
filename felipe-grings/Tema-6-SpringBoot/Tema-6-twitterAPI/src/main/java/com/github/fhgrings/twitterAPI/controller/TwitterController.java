package com.github.fhgrings.twitterAPI.controller;

import com.github.fhgrings.twitterAPI.service.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import twitter4j.TwitterException;

@RestController
public class TwitterController {

    private TotalTweets tweets = new TotalTweets();

    @RequestMapping("/")
    public String index() {
        return "Pong1.2!";

    }

    @RequestMapping(value = "/tweet", params = {"user"})
    @ResponseBody
    public int totalTweets(@RequestParam(value = "user") String user) throws TwitterException {
        return tweets.execute(user);

    }
}