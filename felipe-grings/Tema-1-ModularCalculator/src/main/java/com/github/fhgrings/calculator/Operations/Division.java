package com.github.fhgrings.calculator.Operations;

public class Division implements Operations {
    private double value1;
    private double value2;

    public Division(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;
        calculate();
    }

    @Override
    public double calculate() {
        return value1/value2;
    }
}



