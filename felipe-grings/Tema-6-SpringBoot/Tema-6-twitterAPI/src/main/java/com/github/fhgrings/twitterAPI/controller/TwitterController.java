package com.github.fhgrings.twitterAPI.controller;

import com.github.fhgrings.twitterAPI.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TwitterController {

    private TotalTweets tweets = new TotalTweets();

    @RequestMapping(value = "/tweet", params = {"user"})
    @ResponseBody
    public ResponseEntity totalTweets(@RequestParam(value = "user") String user)  {
        try{
            return ResponseEntity.ok(tweets.execute(user));
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: User not found");
        }
    }
}