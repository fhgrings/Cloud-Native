package com.github.vinifkroth.cloudnative.tema5.singleton;

import java.util.HashMap;
import java.util.Map;

import com.github.vinifkroth.cloudnative.tema5.constants.TollPrices;

public class PriceMapSingleton {

	private static Map<Integer, Double> values;

	public static synchronized Map<Integer, Double> getInstance() {
		if (values == null) {
			values = new HashMap<>();
			values.put(1, TollPrices.BIKE);
			values.put(2, TollPrices.MOTORCYCLE);
			values.put(3, TollPrices.CAR);
			values.put(4, TollPrices.BUS);
			values.put(5, TollPrices.TRUCK);
		}
		return values;
	}
}
