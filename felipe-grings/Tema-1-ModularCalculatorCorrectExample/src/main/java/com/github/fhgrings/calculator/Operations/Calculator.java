package com.github.fhgrings.calculator.Operations;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public Map<String, Class> mapOperations;
    private List<Operations> listHistoryCalculator;

    @Autowired
    public Calculator (){
        mapOperations = new HashMap<>();
        mapOperations.put("+", Sum.class );
        mapOperations.put("-", Subtraction.class);
        mapOperations.put("*", Multiply.class);
        mapOperations.put("/", Division.class);
        mapOperations.put("^", Pow.class);

        listHistoryCalculator = new ArrayList<>();
    }

    public double finishCalculation(double value1, double value2, String operator) throws Exception {
        if ("+-*/".contains(operator)){
            try {
                Operations calculatorResult =(Operations)mapOperations.get(operator).getConstructor(double.class, double.class).newInstance(value1,value2);
                listHistoryCalculator.add(calculatorResult);
                return calculatorResult.getResult();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new Exception("ERROR: Operator doesn't exists");
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

