package com.github.rafaritter44.cloud_native.microservices.github_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubUserDTO {

    @JsonProperty("public_repos")
    private int repoCount;

    public int getRepoCount() {
        return repoCount;
    }
}
