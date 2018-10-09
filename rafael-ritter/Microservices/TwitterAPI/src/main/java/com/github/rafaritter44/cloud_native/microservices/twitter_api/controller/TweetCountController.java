package com.github.rafaritter44.cloud_native.microservices.twitter_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.rafaritter44.cloud_native.microservices.twitter_api.service.TweetCountService;

import twitter4j.TwitterException;

@Controller
@RestController
@EnableAutoConfiguration
public class TweetCountController {
	
	@Autowired
	private TweetCountService tweetCountService;
	
	@RequestMapping("/{user}")
	@ResponseBody
	public int getTweetCount(@PathVariable(value="user") String user) throws TwitterException {
		return tweetCountService.getTweetCount(user);
	}
	
	@ExceptionHandler(TwitterException.class)
    public String handleUserNotFoundException(TwitterException exception) {
    	return exception.getMessage();
    }

}
