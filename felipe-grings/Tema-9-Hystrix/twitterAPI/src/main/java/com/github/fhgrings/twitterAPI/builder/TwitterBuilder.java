package com.github.fhgrings.twitterAPI.builder;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterBuilder {

    @Bean
    public twitter4j.Twitter build() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAccessTokenSecret(System.getenv("ACCESS_TOKEN_SECRET"))
                .setOAuthAccessToken(System.getenv("ACCESS_TOKEN"))
                .setOAuthConsumerKey(System.getenv("CONSUMER_KEY"))
                .setOAuthConsumerSecret(System.getenv("CONSUMER_SECRET"));

        return new TwitterFactory(cb.build()).getInstance();
    }
}
