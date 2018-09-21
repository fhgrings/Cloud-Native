package com.github.fhgrings.calculator.Config;

import com.github.fhgrings.calculator.Operations.Division;
import com.github.fhgrings.calculator.Operations.Operations;

public class GESPONE {
    //public void division(double value1, double value2) {
    //    Division division = new Division(value1,value2);

    //}

    public Operations division(double value1, double value2) {
        Division division = new Division(value1,value2);
        return division;
    }

//    public Operations division() {
//        //Operations op = new Operations();
//        return op;
//    }
}
