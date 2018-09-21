package com.github.fhgrings.calculator.App;

import com.github.fhgrings.calculator.Operations.Calculator;
import com.github.fhgrings.calculator.Config.AppConfig;
import com.github.fhgrings.calculator.Operations.Division;
import com.github.fhgrings.calculator.Operations.Operations;
import com.github.fhgrings.calculator.Operations.Sum;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main (String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");

        calculator.finishCalculation(1,2,"+");
//        calculator.finishCalculation(1,2,"/");
//        calculator.finishCalculation(2.5,2.2,"-");
//        calculator.finishCalculation(1,2,"*");
//        calculator.finishCalculation(1,2,"k");
//        calculator.finishCalculation(1,0,"/");

        calculator.printMapHistory();

        Map<String, Class> map = new HashMap();
        map.put("+", Division.class);
        System.out.println(map.get("+"));

        System.out.println(map.get("+").getConstructor().newInstance(1D));
        //Division d =  div.newInstance(1);


    }
}
