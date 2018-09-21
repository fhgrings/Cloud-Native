package com.github.vinifkroth.cloudnative.tema2.service;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;

public class ShortTrim implements Service {

	private static final double price = 50;

	@Override
	public String doService(Pet pet) {
		return "The pet: " + pet.getName() + " had his fur trimmed just a little at the cost of: " + price;
	}
	@Override
	public double getPrice() {
		return price;
	}

}
