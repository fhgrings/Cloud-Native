package com.github.fhgrings.toll.config;

import com.github.fhgrings.toll.app.Toll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationSingleton {


    private ApplicationSingleton(){

    }

    private static class ApplicationHolder {
        static final ApplicationContext appSingleton = new AnnotationConfigApplicationContext(TollConfig.class);
    }

    public static ApplicationContext getApplicationSingleton(){
        return ApplicationHolder.appSingleton;
    }


}
