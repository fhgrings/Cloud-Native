package com.github.fhgrings.calculator.operations;

public abstract class Operations {

    double value1;
    double value2;
    double result;

    public abstract double calculate();

    double resultTo4Decimals (double result){
        return Math.round(result*1000.0)/1000.0;
    }

    String getResult() {
        return String.valueOf(result);
    }

    abstract void printResult();

}
