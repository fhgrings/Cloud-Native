package com.github.fhgrings.GitHubAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublicRepos {

    @JsonProperty("public_repos")
    private Integer publicRepos;


    public Integer getPublicRepos() {
        return publicRepos;
    }


}
