package com.github.fhgrings.toll.service;

public class CalculateChange {
    private double change;

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double calculate(String vehicleType, int extraAxis, double payment) throws Exception {

        if(PriceMap.getMapValues().get(vehicleType) != null) {
            change =  payment - PriceMap.getMapValues().get(vehicleType) + PriceMap.getMapValues().get("axis")*extraAxis;
            if (change < 0)
                throw new Exception("Need more money");
            return change;
        }
        throw new Exception("Invalid vehicleType");
    }
}
