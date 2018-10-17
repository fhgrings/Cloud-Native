package com.github.rafaritter44.cloud_native.microservices.github_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.rafaritter44.cloud_native.microservices.github_api.exception.UserNotFoundException;
import com.github.rafaritter44.cloud_native.microservices.github_api.service.RepoCountService;

@Controller
@RestController
@EnableAutoConfiguration
public class RepoCountController {

    @Autowired
    private RepoCountService repoCountService;

    @RequestMapping("/{username}")
    @ResponseBody
    public int getRepoCount(@PathVariable(value="username") String username) throws UserNotFoundException {
    	return repoCountService.getRepoCount(username);
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException exception) {
    	return exception.getMessage();
    }

}
