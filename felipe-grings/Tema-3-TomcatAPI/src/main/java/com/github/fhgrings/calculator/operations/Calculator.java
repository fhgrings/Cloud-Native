package com.github.fhgrings.calculator.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public Map<String, Class> mapOperations;
    private List<Operations> listHistoryCalculator;

    public Calculator (){
        mapOperations = new HashMap<>();
        mapOperations.put("sum", Sum.class );
        mapOperations.put("sub", Subtraction.class);
        mapOperations.put("mult", Multiply.class);
        mapOperations.put("div", Division.class);
        mapOperations.put("pow", Pow.class);

        listHistoryCalculator = new ArrayList<>();
    }

    public Double calculate(double value1, double value2, String operator){
        if(mapOperations.get(operator) != null) {
            try {
                Operations calculatorResult = (Operations) mapOperations.get(operator).getConstructor(double.class, double.class).newInstance(value1, value2);
                listHistoryCalculator.add(calculatorResult);
                return calculatorResult.getResult();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getMapHistory() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Operations historic : listHistoryCalculator){
            stringBuffer.append(historic.calculate() + "\n");
        }
        return stringBuffer.toString();
    }

    public void printMapHistory() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Operations historic : listHistoryCalculator){
            stringBuffer.append(historic.calculate() + "\n");
        }
    }
}

