package com.github.rafaritter44.cloud_native.microservices.twitter_github_api.model;

public class GitHubUser {
	
	private String username;
	private int repoCount;
	
	public GitHubUser(String username, int repoCount) {
		this.username = username;
		this.repoCount = repoCount;
	}
	
	public String getUsername() { return username; }
	public int getRepoCount() { return repoCount; }

}
