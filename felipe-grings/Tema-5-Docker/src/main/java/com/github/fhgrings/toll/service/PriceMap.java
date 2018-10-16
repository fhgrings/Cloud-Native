package com.github.fhgrings.toll.service;

import java.util.HashMap;
import java.util.Map;

public class PriceMap {
    private static Map<String,Double> mapValues;

    static {
        mapValues = new HashMap<>();
    }

    public static Map<String,Double> getMapValues() {
            mapValues.put("fusca",2.11D);
            mapValues.put("bus",1.59D);
            mapValues.put("bike",0.49D);
            mapValues.put("moto",1D);
            mapValues.put("truck",3.95D);
            mapValues.put("Extra Axis",1D);
        return mapValues;
    }
}