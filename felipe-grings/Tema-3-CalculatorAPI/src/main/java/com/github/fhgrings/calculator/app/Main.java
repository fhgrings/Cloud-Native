package com.github.fhgrings.calculator.app;

import com.github.fhgrings.calculator.operations.Calculator;
import com.github.fhgrings.calculator.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main (String[] args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");

        calculator.finishCalculation(1,2,"sum");
        calculator.finishCalculation(3,2.,"div");
        calculator.finishCalculation(2.5,2.2,"sub");
        calculator.finishCalculation(1,2,"mult");
        calculator.finishCalculation(1,2,"kk");
        calculator.finishCalculation(10,0,"div");

        System.out.println("\n====================== Memory Data =====================\n");
        calculator.printMapHistory();
    }
}