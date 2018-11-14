package com.github.fhgrings.toll.service;

import com.github.fhgrings.toll.exception.InvalidVehicle;
import com.github.fhgrings.toll.exception.NotEnoughMoney;

public class CalculateChange {


    public double calculate(String vehicleType, int extraAxis, double payment){

        Double vehiclePrice = PriceMap.getMapValues().get(vehicleType);

        if(vehiclePrice == null)
            throw new InvalidVehicle("Invalid vehicle type");

        double change =  payment - vehiclePrice - PriceMap.getMapValues().get("Extra Axis")*extraAxis;
        if (change < 0)
            throw new NotEnoughMoney("Need more money");

        return change;

    }
}
