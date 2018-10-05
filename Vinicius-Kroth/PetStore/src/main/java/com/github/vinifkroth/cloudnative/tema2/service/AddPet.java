package com.github.vinifkroth.cloudnative.tema2.service;

import java.util.List;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;
import com.google.inject.Singleton;

@Singleton
public class AddPet {

	public boolean add(List<Pet> list, Pet pet) {
		return list.add(pet);
	}

}
