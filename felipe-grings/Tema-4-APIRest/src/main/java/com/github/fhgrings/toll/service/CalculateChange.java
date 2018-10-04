package com.github.fhgrings.toll.service;

import com.github.fhgrings.toll.exception.InvalidVehicle;
import com.github.fhgrings.toll.exception.NotEnoughMoney;

public class CalculateChange {


    public double calculate(String vehicleType, int extraAxis, double payment){

        if(PriceMap.getMapValues().get(vehicleType) != null) {
            double change =  payment - PriceMap.getMapValues().get(vehicleType) + PriceMap.getMapValues().get("axis")*extraAxis;
            if (change < 0)
                throw new NotEnoughMoney("Need more money");
            return change;
        }
        throw new InvalidVehicle("Invalid vehicle type");
    }
}
