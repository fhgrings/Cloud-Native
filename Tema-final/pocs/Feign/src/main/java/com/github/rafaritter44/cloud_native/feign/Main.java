package com.github.rafaritter44.cloud_native.feign;

import java.util.List;

import com.github.rafaritter44.cloud_native.feign.model.GitHubUser;
import com.github.rafaritter44.cloud_native.feign.model.Repository;

import feign.Feign;
import feign.gson.GsonDecoder;

public class Main {
	
	public static void main(String args[]) {
		GitHubUser user = Feign.builder()
				.decoder(new GsonDecoder())
				.target(GitHubUser.class, "https://api.github.com");
		List<Repository> repositories = user.repositories("rafaritter44");
		for(Repository repo: repositories) {
			System.out.println("name: " +repo.getName() + " | language: " +
					repo.getLanguage() + " | size: " + repo.getSize());
		}
	}
	
}
