package com.github.fhgrings.springboot.controller;


import com.github.fhgrings.springboot.github.TotalRepos;
import com.github.fhgrings.springboot.twitter.TotalTweets;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegratorController {
    TotalRepos totalRepos = new TotalRepos();
    TotalTweets totalTweets = new TotalTweets();

    @RequestMapping("/ping")
    public String ping() {
        return "pong1.2";
    }

    @RequestMapping(value = "/search", params = {"user"})
    @ResponseBody
    public String totalRepos(@RequestParam(value = "user") String user) throws Exception {
        try {
            Integer userRepos = totalRepos.execute(user);
            return "GitHub respos: " + totalRepos.execute(user) + "  - Twitter tweets: " + totalTweets.execute(user);
        } catch (Exception e) {
            throw e;
        }
    }
}
