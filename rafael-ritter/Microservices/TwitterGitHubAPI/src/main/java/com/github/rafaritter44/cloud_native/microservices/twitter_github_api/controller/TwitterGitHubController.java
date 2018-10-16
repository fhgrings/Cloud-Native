package com.github.rafaritter44.cloud_native.microservices.twitter_github_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rafaritter44.cloud_native.microservices.twitter_github_api.model.GitHubUser;
import com.github.rafaritter44.cloud_native.microservices.twitter_github_api.model.TwitterUser;
import com.github.rafaritter44.cloud_native.microservices.twitter_github_api.service.GitHubService;
import com.github.rafaritter44.cloud_native.microservices.twitter_github_api.service.TwitterService;

@Controller
@RestController
@EnableAutoConfiguration
public class TwitterGitHubController {
	
	@Autowired private TwitterService twitterService;
	@Autowired private GitHubService gitHubService;
	
	@RequestMapping("/{twitter_username}/{github_username}")
	@ResponseBody
	public String getTweetAndRepoCount(
			@PathVariable(value="twitter_username") String twitterUsername,
			@PathVariable(value="github_username") String gitHubUsername) {
		ObjectMapper mapper = new ObjectMapper();
		StringBuilder builder = new StringBuilder().append("{\"twitter\":");
		try {
			builder.append(mapper.writeValueAsString(new TwitterUser(
					twitterUsername, twitterService.getTweetCount(twitterUsername))));
		} catch(Exception exception) {
			builder.append("{\"error\":\"" + exception.getMessage() + "\"}");
		}
		builder.append(",\"github\":");
		try {
			builder.append(mapper.writeValueAsString(new GitHubUser(
					gitHubUsername, gitHubService.getRepoCount(gitHubUsername))));
		} catch(Exception exception) {
			builder.append("{\"error\":\"" + exception.getMessage() + "\"}");
		}
		return builder.append("}").toString();
	}

}
