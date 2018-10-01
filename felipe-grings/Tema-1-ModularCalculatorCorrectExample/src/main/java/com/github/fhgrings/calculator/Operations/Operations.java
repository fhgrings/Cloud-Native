package com.github.fhgrings.calculator.Operations;

public abstract class Operations {

    double value1;
    double value2;
    double result;

    public abstract double calculate();

    double resultTo4Decimals (double result){
//        return result;
        return Math.round(result*1000.0)/1000.0;

    }

    double getResult() {
        return result;
    }

    abstract void printResult();

}
