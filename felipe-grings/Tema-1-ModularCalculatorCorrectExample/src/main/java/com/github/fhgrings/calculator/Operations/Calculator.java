package com.github.fhgrings.calculator.Operations;

import com.github.fhgrings.calculator.Map.ListHistoryCalculator;
import com.github.fhgrings.calculator.Map.MapOperations;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;

public class Calculator {

    private MapOperations mapOperations;
    private ListHistoryCalculator listHistoryCalculator;

    @Autowired
    public Calculator (MapOperations mapOperations, ListHistoryCalculator listHistoryCalculator){
        this.mapOperations = mapOperations;
        this.listHistoryCalculator = listHistoryCalculator;
    }

    public double finishCalculation(double value1, double value2, String operator) {
        if ("+-*/".contains(operator)){
            try {
                return listHistoryCalculator.addCalculatorHistoric((Operations) mapOperations.getMapOperation().get(operator).getConstructor(double.class, double.class).newInstance(value1, value2)).getResult();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else
            System.out.println("ERROR: Operator doesn't exists;");
        return 99999999;
    }

    public String getMapHistory() {
        return listHistoryCalculator.listCalculatorHistoric();
    }

    public void printMapHistory() {
        listHistoryCalculator.listCalculatorHistoric();
    }
}

