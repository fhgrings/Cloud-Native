package com.github.fhgrings.calculator.Operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public Map<String, Class> mapOperations;
    private List<Operations> listHistoryCalculator;

    public Calculator (){
        mapOperations = new HashMap<>();
        mapOperations.put("+", Sum.class );
        mapOperations.put("-", Subtraction.class);
        mapOperations.put("*", Multiply.class);
        mapOperations.put("/", Division.class);
        mapOperations.put("^", Pow.class);

        listHistoryCalculator = new ArrayList<>();
    }

    public Double finishCalculation(double value1, double value2, String operator) throws Exception {


            try {
                if(mapOperations.get(operator) != null) {
                    Operations calculatorResult = (Operations) mapOperations.get(operator).getConstructor(double.class, double.class).newInstance(value1, value2);
                    listHistoryCalculator.add(calculatorResult);
                    return calculatorResult.getResult();
                }
                throw new Exception("Error");

            } catch (Exception e) {
                e.printStackTrace();
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

