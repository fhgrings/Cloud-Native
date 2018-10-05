package com.github.rafaritter44.cloud_native.microservices.github_api.controller;

import com.github.rafaritter44.cloud_native.microservices.github_api.service.RepoCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@EnableAutoConfiguration
public class RepoCountController {

    @Autowired
    private RepoCountService repoCountService;

    @RequestMapping("/{user}")
    @ResponseBody
    public int getRepoCount(@PathVariable(value="user") String user) {
        return repoCountService.getRepoCount(user);
    }

}
