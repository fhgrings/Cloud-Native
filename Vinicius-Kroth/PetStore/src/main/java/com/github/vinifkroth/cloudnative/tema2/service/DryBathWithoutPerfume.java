package com.github.vinifkroth.cloudnative.tema2.service;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;
import com.google.inject.Singleton;

@Singleton
public class DryBathWithoutPerfume implements Service {

	private static final int price = 110;

	@Override
	public String doService(Pet pet) {
		return "The pet :" + pet.getName() + " took a dry bath but didn't spray perfume at the cost of: " + price;
	}

	@Override
	public double getPrice() {
		return price;
	}

}
