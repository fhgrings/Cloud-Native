package com.github.fhgrings.rxNetty.operations;

public class Division implements Operation {
    private double value1;
    private double value2;

    public Division(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public double calculate() {
        return value1/value2;
    }
}



