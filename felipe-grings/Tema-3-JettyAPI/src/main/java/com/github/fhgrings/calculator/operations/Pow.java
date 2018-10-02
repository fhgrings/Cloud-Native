package com.github.fhgrings.calculator.operations;

public class Pow implements Operations {
    double value1;
    double value2;
    double result;
    ResultTo4Decimals roundResult;


    public Pow(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;
        roundResult = new ResultTo4Decimals();
        calculate();
    }

    @Override
    public double calculate() {
        result = roundResult.execute(Math.pow(value1,value2));
        printResult();
        return result ;
    }

    @Override
    public void printResult() {
        System.out.println(value1 + " ^ " + value2 + " = " + result);
    }

    @Override
    public double getResult(){
        return result;
    }
}