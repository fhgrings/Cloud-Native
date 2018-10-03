package com.github.fhgrings.calculator.App;

import com.github.fhgrings.calculator.Operations.Calculator;
import com.github.fhgrings.calculator.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main (String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");

        calculator.calculate(1,2,"sum");
        calculator.calculate(3,2.,"div");
        calculator.calculate(2.5,2.2,"sub");
        calculator.calculate(1,2,"mult");
        calculator.calculate(1,2,"kk");
        calculator.calculate(10,0,"div");

        System.out.println("\n====================== Memory Data =====================\n");
        calculator.printMapHistory();
    }
}
