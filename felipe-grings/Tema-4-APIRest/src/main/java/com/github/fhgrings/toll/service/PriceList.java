package com.github.fhgrings.toll.service;

public class PriceList {

    public String priceList() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String type : PriceMap.getMapValues().keySet()){
            stringBuffer.append(" | " + type + " | $" + PriceMap.getMapValues().get(type) + " | \n");
        }
        stringBuffer.append("  Extra axis   " + PriceMap.getMapValues().get("axis"));
        return stringBuffer.toString();
    }
}
