package com.github.vinifkroth.cloudnative.tema2.service;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;

public interface Service {

	public String doService(Pet pet);
	
	public double getPrice();
}
