package com.github.vinifkroth.cloudnative.tema2.service;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;

public class LongTrim implements Service {
	private static final int price = 60;

	@Override
	public String doService(Pet pet) {
		return "The pet: " + pet.getName() + " had his fur trimmed just a bit at the cost of: " + price;
	}

	@Override
	public double getPrice() {
		return price;
	}

}
