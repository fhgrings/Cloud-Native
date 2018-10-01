package com.github.rafaritter44.cloud_native.jetty.app;

import com.github.rafaritter44.cloud_native.jetty.app.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculadoraSingleton {

    private static class ApplicationContextSingleton {
        static final ApplicationContext INSTANCIA = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public static Calculadora getInstance() {
        return (Calculadora) ApplicationContextSingleton.INSTANCIA.getBean("calculadora");
    }

    private CalculadoraSingleton() {}

}
