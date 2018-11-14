package com.github.fhgrings.Hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class HelloWorld {

    public static void main(String[] args) {


        HystrixCommand.Setter config = HystrixCommand
                .Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldSample"));


        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
        commandProperties.withExecutionTimeoutInMilliseconds(1_000);
        config.andCommandPropertiesDefaults(commandProperties);

        System.out.println(new CommandHelloWorld( config,"GitHub_Acount").execute());
    }
}


