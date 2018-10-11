package com.github.fhgrings.GitHubAPI.controller;


import com.github.fhgrings.GitHubAPI.service.TotalRepos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {
    TotalRepos totalRepos = new TotalRepos();

    @RequestMapping("/")
    public String ping() {
        return "pong1.0";
    }

    @RequestMapping(value = "/repos",params ={"user"})
    @ResponseBody
    public int totalRepos(@RequestParam(value = "user") String user) throws Exception {
        try {
            return totalRepos.execute(user);
        } catch (Exception e) {
            throw e;
        }
    }
}
