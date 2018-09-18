package com.github.fhgrings.calculator.Operations;

public class Multiply implements Operations {
    @Override
    public String calculate(double value1, double value2) {
        double result = resultTo4Decimals(value1*value2);
        return value1 + " * " + value2 + " = " + result ;
    }

    @Override
    public double resultTo4Decimals(double result) {
        return Math.round(result*1000.0)/1000;
    }
}
