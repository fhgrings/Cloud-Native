package com.github.fhgrings.rxNetty.operations;

import com.github.fhgrings.rxNetty.exception.ConstructorException;
import com.github.fhgrings.rxNetty.exception.InvalidOperator;

import java.util.*;

public class Calculator {
    public Map<String, Class> mapOperations;
    private List<Operation> listHistoryCalculator;

    public Calculator (){
        mapOperations = new HashMap<>();
        mapOperations.put("sum", Sum.class );
        mapOperations.put("sub", Subtraction.class);
        mapOperations.put("mult", Multiply.class);
        mapOperations.put("div", Division.class);
        mapOperations.put("pow", Pow.class);

        listHistoryCalculator = new ArrayList<>();
    }

    public Double calculate(Double value1, Double value2, String operator)throws Exception{

        Operation calculatorResult = calculatorConstructor(operator,value1,value2);
        listHistoryCalculator.add(calculatorResult);

        return calculatorResult.calculate();

    }

    public List<Double> getMapHistory() {
        List<Double> historico = new ArrayList<>();
        for (Operation historic : listHistoryCalculator){
            historico.add(historic.calculate());
        }
        return historico;
    }



    public Operation calculatorConstructor(String operator,Double value1, Double value2) {
        Class operation = mapOperations.get(operator);

        if (operation == null)
            throw new InvalidOperator("ERROR: Invalid Operator");

        try {
            return (Operation) operation.getConstructor(double.class, double.class).newInstance(value1, value2);
        } catch (Exception exception) {
            throw new ConstructorException("ERROR: Object not constructed");
        }
    }
}

