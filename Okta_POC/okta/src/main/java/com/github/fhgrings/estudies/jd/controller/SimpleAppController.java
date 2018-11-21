package com.github.fhgrings.estudies.jd.controller;

import com.github.fhgrings.estudies.jd.command.Config;
import com.github.fhgrings.estudies.jd.command.PingCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class SimpleAppController {

    @Autowired
    private Config config;

    @RequestMapping("/")
    public String home() {
        return "home";
    }
    
    @RequestMapping("/restricted")
    public String restricted() {
        return "restricted";
    }

    @RequestMapping("/ping")
    public String ping() {
        return "ping";
    }

    @RequestMapping("/pong")
    public String pong() {
        return new PingCommand(config.getCommandConfig("pong")).execute();
    }


    @RequestMapping("/rest")
    @ResponseBody
    public ResponseEntity rest() {
        return ResponseEntity.status(HttpStatus.OK).body("Thats fine");

    }

    @RequestMapping("/html")
    public String restHTML() {
        return "/rest";

    }



}