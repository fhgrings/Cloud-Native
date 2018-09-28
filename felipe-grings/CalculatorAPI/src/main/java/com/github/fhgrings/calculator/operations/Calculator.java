package com.github.fhgrings.calculator.operations;

import com.github.fhgrings.calculator.map.ListHistoryCalculator;
import com.github.fhgrings.calculator.map.MapOperations;
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

    public String finishCalculation(double value1, double value2, String operator) {
        if ("sum sub pow mult div".contains(operator) || value2 == 0){
            try {
//                double result =  mapOperations.getMapOperation().get(operator).getConstructor(double.class, double.class).newInstance(value1, value2);
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
        }

        return "ERROR: Operator doesn't exists;";
    }

    public String getMapHistory() {
        return listHistoryCalculator.listCalculatorHistoric();
    }

    public void printMapHistory() {
        listHistoryCalculator.listCalculatorHistoric();
    }

}

