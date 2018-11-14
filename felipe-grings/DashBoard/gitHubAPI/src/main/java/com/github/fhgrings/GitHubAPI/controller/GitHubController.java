package com.github.fhgrings.GitHubAPI.controller;


import com.github.fhgrings.GitHubAPI.service.TotalRepos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {
    private TotalRepos totalRepos = new TotalRepos();

    @RequestMapping(value = "/repos",params ={"user"})
    @ResponseBody
    public ResponseEntity totalRepos(@RequestParam(value = "user") String user) throws Exception {
        try {
            return ResponseEntity.ok(totalRepos.execute(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: User Not Found");
        }
    }
}
