package com.github.fhgrings.twitterAPI.service;

import com.github.fhgrings.twitterAPI.builder.TwitterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.TwitterException;


public class TotalTweets {

    @Autowired
    private TwitterBuilder twitter = new TwitterBuilder();

    public int execute(String user) throws TwitterException {
        return twitter.build().showUser(user).getStatusesCount();
    }
}
