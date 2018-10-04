package com.github.rafaritter44.cloud_native.docker.singleton;

import com.github.rafaritter44.cloud_native.docker.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContextSingleton {

    private static class AppContextHolder {
        static final ApplicationContext INSTANCIA = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public static ApplicationContext getInstance() {
        return AppContextHolder.INSTANCIA;
    }

    private AppContextSingleton() {}

}
