package com.github.rafaritter44.cloud_native.feign.model;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface GitHubUser {
	@RequestLine("GET /users/{user}/repos")
	List<Repository> repositories(@Param("user") String user);
}
