package com.github.rafaritter44.cloud_native.rxnetty.calculator;

public class Exponentiation implements Operation {

    private double operand1;
    private double operand2;

    public Exponentiation(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public double calculate() {
        return Math.pow(operand1, operand2);
    }

}
