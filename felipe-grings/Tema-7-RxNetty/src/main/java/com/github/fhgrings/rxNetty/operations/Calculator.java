package com.github.fhgrings.rxNetty.operations;

import com.github.fhgrings.rxNetty.exception.ConstructorException;
import com.github.fhgrings.rxNetty.exception.InvalidOperator;
import com.github.fhgrings.rxNetty.exception.InvalidValue;
import org.antlr.stringtemplate.language.ArrayWrappedInList;

import java.lang.reflect.Constructor;
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

        Operation calculatorResult;

        try {
            calculatorResult = (Operation) objectCreator(operator).newInstance(value1, value2);
        } catch (InvalidOperator exception) {
            throw exception;
        }

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



    public Constructor objectCreator(String operator) {
        Class operation = mapOperations.get(operator);

        if (operation == null)
            throw new InvalidOperator("ERROR: Invalid Operator");

        try {
            return operation.getConstructor(double.class, double.class);
        } catch (Exception exception) {
            throw new ConstructorException("ERROR: Object not constructed");
        }
    }
}

