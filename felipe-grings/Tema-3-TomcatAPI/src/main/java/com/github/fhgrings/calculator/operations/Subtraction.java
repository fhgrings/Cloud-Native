package com.github.fhgrings.calculator.operations;

public class Subtraction implements Operations {
    double value1;
    double value2;
    double result;
    ResultTo4Decimals roundResult;

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public ResultTo4Decimals getRoundResult() {
        return roundResult;
    }

    public void setRoundResult(ResultTo4Decimals roundResult) {
        this.roundResult = roundResult;
    }

    public Subtraction(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;
        roundResult = new ResultTo4Decimals();
        calculate();
    }

    @Override
    public double calculate() {
        result = roundResult.execute(value1-value2);
        printResult();
        return result ;
    }

    @Override
    public double getResult() {
        return result;
    }

    @Override
    public void printResult() {
        System.out.println(value1 + " - " + value2 + " = " + result);
    }
}


