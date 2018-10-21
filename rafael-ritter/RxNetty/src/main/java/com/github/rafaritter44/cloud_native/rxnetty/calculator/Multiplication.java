package com.github.rafaritter44.cloud_native.rxnetty.calculator;

public class Multiplication implements Operation {

    private double operand1;
    private double operand2;

    public Multiplication(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public double calculate() {
        return operand1 * operand2;
    }

}
