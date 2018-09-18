package com.github.fhgrings.calculator.Map;

import java.util.ArrayList;
import java.util.List;

public class MapHistoryCalculator {
    List<String> calculatorHistoricList = new ArrayList<>();

    public String addCalculatorHistoric (String operationResult) {
        calculatorHistoricList.add(operationResult);
        return operationResult;
    }

    public String listCalculatorHistoric () {
        StringBuffer stringBuffer = new StringBuffer();
        for (String historic : calculatorHistoricList){
            stringBuffer.append(historic + "\n");
        }
        return stringBuffer.toString();
    }
}

