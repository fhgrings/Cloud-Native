package com.github.fhgrings.calculator.operations;

public class Sum implements Operations {
    double value1;
    double value2;
    double result;
    ResultTo4Decimals roundResult;


    public Sum(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;
        roundResult = new ResultTo4Decimals();
        calculate();
    }


    @Override
    public double calculate() {
        result = roundResult.execute(value1+value2);
        printResult();
        return result ;
    }

    @Override
    public void printResult() {
        System.out.println( value1 + " + " + value2 + " = " + result);

    }

    @Override
    public double getResult() {
        return result;
    }
}