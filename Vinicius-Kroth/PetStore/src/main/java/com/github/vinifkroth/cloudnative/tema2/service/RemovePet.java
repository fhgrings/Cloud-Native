package com.github.vinifkroth.cloudnative.tema2.service;

import java.util.List;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;
import com.google.inject.Singleton;

@Singleton
public class RemovePet {
	public boolean remove(List<Pet> list, String petId) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(petId)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
}
