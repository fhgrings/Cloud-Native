package com.github.fhgrings.rxNetty.operations;

public class ResultTo4Decimals {

    public double execute (double result){
        return Math.round(result*1000.0)/1000.0;

    }
}
