package com.github.fhgrings.calculator.Operations;

import com.github.fhgrings.calculator.Map.ListHistoryCalculator;
import com.github.fhgrings.calculator.Map.MapOperations;
import org.springframework.beans.factory.annotation.Autowired;

public class Calculator {

    private MapOperations mapOperations;
    private ListHistoryCalculator listHistoryCalculator;

    @Autowired
    public Calculator (MapOperations mapOperations, ListHistoryCalculator listHistoryCalculator){
        this.mapOperations = mapOperations;
        this.listHistoryCalculator = listHistoryCalculator;
    }

    public String finishCalculation(double value1, double value2, String operator) {
        if("+-*/".contains(operator))
            return listHistoryCalculator.addCalculatorHistoric(mapOperations.getMapOperation().get(operator).calculate(value1,value2));
        else
            return listHistoryCalculator.addCalculatorHistoric("ERROR: Operator doesn't exist!");
    }

    public String getMapHistory() {
        return listHistoryCalculator.listCalculatorHistoric();
    }

    public void printMapHistory() {
        System.out.println(listHistoryCalculator.listCalculatorHistoric());
    }
}

