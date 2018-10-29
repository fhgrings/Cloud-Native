package com.github.fhgrings.springboot.controller;


import com.github.fhgrings.springboot.service.GithubService;
import com.github.fhgrings.springboot.service.TwitterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegratorController {
    private GithubService githubService = new GithubService();
    private TwitterService twitterService = new TwitterService();

    @RequestMapping(value = "/search", params = {"user"})
    @ResponseBody
    public String userSearch(@RequestParam(value = "user") String user){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GitHub repos: ");

        try {
            stringBuffer.append(githubService.execute(user))
                    .append("\n");
        } catch (Exception exception) {
            stringBuffer.append(exception.getMessage())
            .append("\n");
        }

        stringBuffer.append("Twitter tweets: ");

        try {
            stringBuffer.append(twitterService.execute(user))
                    .append("\n");
        } catch (Exception exception) {
            stringBuffer.append(exception.getMessage())
                    .append("\n");
        }

        return stringBuffer.toString();

    }
}
