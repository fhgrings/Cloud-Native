package com.github.fhgrings.rxNetty.operations;

public class Subtraction implements Operation {
    private double value1;
    private double value2;
    private ResultTo4Decimals roundResult;

    public Subtraction(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;
        roundResult = new ResultTo4Decimals();
    }

    @Override
    public double calculate() {
        return roundResult.execute(value1-value2);
    }
}


