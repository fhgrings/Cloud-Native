package com.github.fhgrings.calculator.App;

import com.github.fhgrings.calculator.Operations.Calculator;
import com.github.fhgrings.calculator.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main (String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");

        System.out.println(calculator.calculate(1,2,"sum"));
        System.out.println(calculator.calculate(3,2.,"div"));
        System.out.println(calculator.calculate(2.5,2.2,"sub"));
        System.out.println(calculator.calculate(1,2,"mult"));
        System.out.println(calculator.calculate(1,2,"kk"));
        System.out.println(calculator.calculate(10,0,"div"));

        System.out.println("\n====================== Memory Data =====================\n");
        System.out.println(calculator.printMapHistory());
    }
}
