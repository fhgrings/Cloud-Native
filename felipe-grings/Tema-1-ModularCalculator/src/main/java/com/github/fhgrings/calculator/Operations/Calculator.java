package com.github.fhgrings.calculator.Operations;

import com.github.fhgrings.calculator.Map.MapHistoryCalculator;
import com.github.fhgrings.calculator.Map.MapOperations;
import org.springframework.beans.factory.annotation.Autowired;

public class Calculator {

    private MapOperations mapOperations;
    private MapHistoryCalculator mapHistoryCalculator;

    @Autowired
    public Calculator (MapOperations mapOperations, MapHistoryCalculator mapHistoryCalculator){
        this.mapOperations = mapOperations;
        this.mapHistoryCalculator = mapHistoryCalculator;
    }

    public String finishCalculation(double value1, double value2, String operator) {
        if("+-*/".contains(operator))
            return mapHistoryCalculator.addCalculatorHistoric(mapOperations.getMapOperation().get(operator).calculate(value1,value2));
        else
            return mapHistoryCalculator.addCalculatorHistoric("ERROR: Operator doesn't exist!");
    }

    public String getMapHistory() {
        return mapHistoryCalculator.listCalculatorHistoric();
    }

    public void printMapHistory() {
        System.out.println(mapHistoryCalculator.listCalculatorHistoric());
    }
}

