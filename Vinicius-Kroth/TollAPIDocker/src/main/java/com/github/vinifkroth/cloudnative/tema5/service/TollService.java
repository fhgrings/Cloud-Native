package com.github.vinifkroth.cloudnative.tema5.service;

import com.github.vinifkroth.cloudnative.tema5.constants.TollPrices;
import com.github.vinifkroth.cloudnative.tema5.exception.InvalidVehicleException;
import com.github.vinifkroth.cloudnative.tema5.exception.NotEnoughMoneyException;
import com.github.vinifkroth.cloudnative.tema5.singleton.PriceMapSingleton;

public class TollService {

	public static String getPrices() {
		return "Prices:\n" + "1.Bycicles: " + TollPrices.BIKE + "\n2.Motorcycles: " + TollPrices.MOTORCYCLE
				+ "\n3.Cars: " + TollPrices.CAR + "\n4.Bus: " + TollPrices.BUS + "\n5.Trucks: " + TollPrices.TRUCK
				+ "\nExtra Truck Axis: " + TollPrices.EXTRA_AXIS;
	}

	public static double chargeFee(int vehicle, double money, int extraAxis)
			throws NotEnoughMoneyException, InvalidVehicleException {

		Double price = PriceMapSingleton.getInstance().get(vehicle);

		if (extraAxis > 0 && vehicle != 5)
			throw new InvalidVehicleException("Invalid operation, only trucks can be charged with extra axis.");
		if (price == null)
			throw new InvalidVehicleException("The chosen option does not match any existing one in our database.");
		
		double change = money - (price + TollPrices.EXTRA_AXIS * extraAxis);

		if (change < 0)
			throw new NotEnoughMoneyException("The money provided is not enough to pay the toll fee.");

		return change;
	}

}
