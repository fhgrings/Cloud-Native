package com.github.vinifkroth.cloudnative.tema2.service;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;
import com.google.inject.Singleton;

@Singleton
public class WaterBathWithoutPerfume implements Service {
	private static final int price = 90;

	@Override
	public String doService(Pet pet) {
		return "The pet :" + pet.getName() + " took a water bath with no perfume, at the cost of: \" + price";
	}
	@Override
	public double getPrice() {
		return price;
	}

}
