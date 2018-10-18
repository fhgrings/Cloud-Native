package com.github.rafaritter44.cloud_native.rxnetty.calculator;

import com.github.rafaritter44.cloud_native.rxnetty.exception.DivisionByZeroException;

public class Division implements Operation {

	private double operand1;
    private double operand2;

    public Division(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public double calculate() {
        if(operand2 == 0D)
            throw new DivisionByZeroException("Cannot divide by zero");
        return operand1 / operand2;
    }
	
}
