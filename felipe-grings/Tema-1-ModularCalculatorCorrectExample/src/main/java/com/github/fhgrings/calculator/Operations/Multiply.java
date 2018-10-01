package com.github.fhgrings.calculator.Operations;

public class Multiply implements Operations {
    double value1;
    double value2;
    double result;
    ResultTo4Decimals roundResult;

    public Multiply(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;
        roundResult = new ResultTo4Decimals();
        calculate();
    }



    @Override
    public double calculate() {
        result = roundResult.execute(value1*value2);
        printResult();
        return result;
    }

    @Override
    public void printResult() {
        System.out.println(value1 + " * " + value2 + " = " + result);
    }

    @Override
    public double getResult(){
        return result;
    }
}
