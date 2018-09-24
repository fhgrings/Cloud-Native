package com.github.fhgrings.calculator.Map;

import com.github.fhgrings.calculator.Operations.Operations;

import java.util.ArrayList;
import java.util.List;

public class ListHistoryCalculator {
    List<Operations> calculatorHistoricList = new ArrayList<>();

    public Operations addCalculatorHistoric (Operations operationResult) {
        calculatorHistoricList.add(operationResult);
        return operationResult;
    }

    public String listCalculatorHistoric () {
        StringBuffer stringBuffer = new StringBuffer();
        for (Operations historic : calculatorHistoricList){
            stringBuffer.append(historic.calculate() + "\n");
        }
        return stringBuffer.toString();
    }
}

