package com.github.fhgrings.calculator.Operations;

public class Multiply implements Operations {
    private double value1;
    private double value2;
    private ResultTo4Decimals roundResult;

    public Multiply(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;
        roundResult = new ResultTo4Decimals();
        calculate();
    }

    @Override
    public double calculate() {
        return roundResult.execute(value1*value2);
    }
}
