package com.github.rafaritter44.cloud_native.microservices.twitter_api.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class AppConfig {
	
	@Bean
	public Twitter twitter() {
		Map<String,String> environment = System.getenv();
		ConfigurationBuilder configBuilder = new ConfigurationBuilder()
				.setOAuthConsumerKey(environment.get("OAUTH_CONSUMER_KEY"))
				.setOAuthConsumerSecret(environment.get("OAUTH_CONSUMER_SECRET"))
				.setOAuthAccessToken(environment.get("OAUTH_ACCESS_TOKEN"))
				.setOAuthAccessTokenSecret(environment.get("OAUTH_ACCESS_TOKEN_SECRET"));
		return new TwitterFactory(configBuilder.build()).getInstance();
	}

}
