package com.github.fhgrings.calculator.operations;

public class Subtraction extends Operations {

    public Subtraction(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;

        calculate();
    }

    @Override
    public double calculate() {
        result = resultTo4Decimals(value1-value2);
        printResult();
        return result ;
    }

    @Override
    void printResult() {
        System.out.println(value1 + " - " + value2 + " = " + result);
    }
}
