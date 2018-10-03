package com.github.fhgrings.toll.app;

import com.github.fhgrings.toll.service.CalculateChange;
import com.github.fhgrings.toll.service.PriceList;
import org.springframework.beans.factory.annotation.Autowired;

public class Toll {

    @Autowired
    public CalculateChange calculateChange;

    @Autowired
    public PriceList priceList;

    public double calculateChange(String vehicleType, int extraAxis, double payment) throws Exception {
        return calculateChange.calculate(vehicleType,extraAxis,payment);
    }

    public String priceList() {
        return priceList.priceList();
    }
}
