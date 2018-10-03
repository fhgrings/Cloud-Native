package com.github.fhgrings.calculator.operations;

public class Division implements Operations {
    double value1;
    double value2;
    double result;

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Division(double value1, double value2 ) {
        this.value1 = value1;
        this.value2 = value2;

        calculate();
    }

    @Override
    public double calculate() {
        result = value1/value2;
        printResult();
        return result;
        }

    @Override
    public void printResult() {
        System.out.println(value1 + " / " + value2 + " = " + result);
    }

    @Override
    public double getResult(){
        return result;
    }
}