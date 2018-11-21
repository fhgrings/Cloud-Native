package com.github.fhgrings.estudies.jd.command;

import com.netflix.hystrix.HystrixCommand;

public class PingCommand extends HystrixCommand<String> {

    public PingCommand(Setter config) {
        super(config);
    }

    @Override
    protected String run() throws Exception {

        wait(20000);
        return "pong";
    }


    @Override
    protected String getFallback() {
        return "ping";
    }
}
