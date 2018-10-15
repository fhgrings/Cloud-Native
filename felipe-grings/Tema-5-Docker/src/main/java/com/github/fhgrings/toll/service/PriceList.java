package com.github.fhgrings.toll.service;

public class PriceList {

    public String priceList() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String type : PriceMap.getMapValues().keySet()){
            stringBuffer.append(" | ")
                    .append(type)
                    .append(" | $")
                    .append(PriceMap.getMapValues().get(type))
                    .append(" | \n");
        }
        return stringBuffer.toString();
    }
}
