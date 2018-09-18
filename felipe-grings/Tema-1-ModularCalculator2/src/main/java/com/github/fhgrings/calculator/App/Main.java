package com.github.fhgrings.calculator.App;

import com.github.fhgrings.calculator.Operations.Calculator;
import com.github.fhgrings.calculator.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main (String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");

        calculator.finishCalculation(1,2,"+");
        calculator.finishCalculation(1,2,"/");
        calculator.finishCalculation(2.5,2.2,"-");
        calculator.finishCalculation(1,2,"*");
        calculator.finishCalculation(1,2,"k");
        calculator.finishCalculation(1,0,"/");

        calculator.printMapHistory();

        double a = 82.133;
        a=Math.round(a*10000.0)/10000.0;
        System.out.println(a);
    }
}
