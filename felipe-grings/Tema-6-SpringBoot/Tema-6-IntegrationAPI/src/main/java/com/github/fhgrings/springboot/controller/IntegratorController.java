package com.github.fhgrings.springboot.controller;


import com.github.fhgrings.springboot.github.TotalRepos;
import com.github.fhgrings.springboot.twitter.TotalTweets;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegratorController {
    private TotalRepos totalRepos = new TotalRepos();
    private TotalTweets totalTweets = new TotalTweets();

    @RequestMapping(value = "/search", params = {"user"})
    @ResponseBody
    public String userSearch(@RequestParam(value = "user") String user){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GitHub repos: ");

        try {
            stringBuffer.append(totalRepos.execute(user))
                    .append("\n");
        } catch (Exception exception) {
            stringBuffer.append(exception.getMessage())
            .append("\n");
        }

        stringBuffer.append("Twitter tweets: ");

        try {
            stringBuffer.append(totalTweets.execute(user))
                    .append("\n");
        } catch (Exception exception) {
            stringBuffer.append(exception.getMessage())
                    .append("\n");
        }

        return stringBuffer.toString();

    }
}
