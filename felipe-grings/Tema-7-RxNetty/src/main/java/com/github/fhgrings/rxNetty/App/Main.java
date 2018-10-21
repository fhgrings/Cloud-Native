package com.github.fhgrings.rxNetty.App;

import com.github.fhgrings.rxNetty.config.AppConfig;
import com.github.fhgrings.rxNetty.operations.Calculator;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.servo.KaryonServoModule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {



    public static void main (String[] args){

        final int PORT = 8080;

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean(Calculator.class);


        System.setProperty("java.awt.headless","true");
        System.setProperty("archaius.deployment.environment","dev");


        Karyon.forRequestHandler(PORT,
                new RxNettyHandler("/calculator", calculator),
                new ArchaiusBootstrapModule("rxnetty-calculator"),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();



    }
}

