package com.github.fhgrings.calculator.App;

import com.github.fhgrings.calculator.Operations.Calculator;
import com.github.fhgrings.calculator.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main (String[] args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");

        calculator.finishCalculation(1,2,"+");
        calculator.finishCalculation(3,2.,"/");
        calculator.finishCalculation(2.5,2.2,"-");
        calculator.finishCalculation(1,2,"*");
        calculator.finishCalculation(1,2,"kk");
        calculator.finishCalculation(10,0,"/");

        System.out.println("\n====================== Memory Data =====================\n");
        calculator.printMapHistory();
    }
}
