package com.github.vinifkroth.cloudnative.tema2.service;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;
import com.google.inject.Singleton;

@Singleton
public class DryBathWithPerfume implements Service {
	private static final int PRICE = 120;

	@Override
	public String doService(Pet pet) {
		return "The pet :" + pet.getName() + " took a dry bath and sprayed some perfume at the cost of: " + PRICE;
	}

	@Override
	public double getPrice() {
		return PRICE;
	}

}
