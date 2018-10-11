package com.github.fhgrings.twitterAPI.service;

import com.github.fhgrings.twitterAPI.builder.TwitterBuilder;
import com.github.fhgrings.twitterAPI.exception.InvalidUser;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.TwitterException;


public class TotalTweets {

    @Autowired
    private TwitterBuilder twitter = new TwitterBuilder();

    public int execute(String user) throws TwitterException {
        Integer totalTweets = twitter.build().showUser(user).getStatusesCount();
        if(totalTweets == null)
            throw new InvalidUser("Invalid User");
        return totalTweets;
        }
}
