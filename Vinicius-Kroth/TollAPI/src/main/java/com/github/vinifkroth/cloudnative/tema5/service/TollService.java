package com.github.vinifkroth.cloudnative.tema5.service;

import com.github.vinifkroth.cloudnative.tema5.constants.TollPrices;
import com.github.vinifkroth.cloudnative.tema5.exception.InvalidVehicleException;
import com.github.vinifkroth.cloudnative.tema5.exception.NotEnoughMoneyException;

public class TollService {

	public static String getPrices() {
		return "Prices:\n" + "1.Bycicles: " + TollPrices.BIKE + "\n2.Motorcycles: " + TollPrices.MOTORCYCLE
				+ "\n3.Cars: " + TollPrices.CAR + "\n4.Bus: " + TollPrices.BUS + "\n5.Trucks: " + TollPrices.TRUCK
				+ "\nExtra Truck Axis: " + TollPrices.EXTRA_AXIS;
	}

	public static double chargeFee(int vehicle, double money, int extraAxis)
			throws NotEnoughMoneyException, InvalidVehicleException {

		if (extraAxis > 0 && vehicle != 5)
			throw new InvalidVehicleException("Invalid operation, only trucks can be charged with extra axis.");
		double change = -1;
		switch (vehicle) {
		case 1:
			change = money - TollPrices.BIKE;
			break;
		case 2:
			change = money - TollPrices.MOTORCYCLE;
			break;
		case 3:
			change = money - TollPrices.CAR;
			break;
		case 4:
			change = money - TollPrices.BUS;
			break;
		case 5:
			change = money - (TollPrices.TRUCK + TollPrices.EXTRA_AXIS * extraAxis);
			break;
		default:
			throw new InvalidVehicleException("The chosen option does not match any existing one in our database.");
		}
		if (change < 0)
			throw new NotEnoughMoneyException("The money provided is not enough to pay the toll fee.");
		return change;
	}

}
