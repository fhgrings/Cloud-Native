package com.github.fhgrings.calculator.operations;

public class ResultTo4Decimals {

    public double execute (double result){
        return Math.round(result*1000.0)/1000.0;

    }
}
