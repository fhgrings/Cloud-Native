package com.github.vinifkroth.cloudnative.tema2.service;

import java.util.ArrayList;
import java.util.List;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;
import com.google.inject.Inject;

public class PetStore {
	@Inject
	DryBathWithPerfume dryBathWithPerfume;
	@Inject
	DryBathWithoutPerfume dryBathWithoutPerfume;
	@Inject
	WaterBathWithoutPerfume waterBathWithoutPerfume;
	@Inject
	WaterBathWithPerfume waterBathWithPerfume;
	@Inject
	LongTrim longTrim;
	@Inject
	ShortTrim shortTrim;
	@Inject
	AddPet addPet;
	@Inject
	RemovePet removePet;
	private List<Pet> petList;
	private List<String> servicesHistory;

	public PetStore() {
		petList = new ArrayList<>();
		servicesHistory = new ArrayList<>();
	}

	public Object[] getPetByAge(int age) {
		return petList.stream()
				      .filter(pet -> pet
				      .getAge() == age)
				      .toArray();
	}

	public boolean addPet(String id, String name, String race, int age) {
		Pet pet = new Pet(id, name, race, age);
		return addPet.add(petList, pet);
	}

	public boolean removePetById(String id) {
		return removePet.remove(petList, id);
	}

	public String trimHair(boolean fullTrim, String petId) {
		Pet pet = retrievePetById(petId);
		if (pet == null)
			return "ID_NOT_ENCOUNTERED_IN_OUR_DATABASE";

		String serviceMessage;
		if (fullTrim) {
			serviceMessage = longTrim.doService(pet);
			servicesHistory.add(serviceMessage);
			pet.setTotalRevenue(pet.getTotalRevenue() + longTrim.getPrice());
			return serviceMessage;
		}

		serviceMessage = shortTrim.doService(pet);
		servicesHistory.add(serviceMessage);
		pet.setTotalRevenue(pet.getTotalRevenue() + shortTrim.getPrice());
		return shortTrim.doService(pet);

	}

	public String washPet(boolean dry, boolean perfume) {
		return "";
	}

	private Pet retrievePetById(String id) {
		return petList.stream()
					  .filter(pet-> pet.getId()
				      .equals(id)).findFirst()
					  .orElse(null);		
	}
}
