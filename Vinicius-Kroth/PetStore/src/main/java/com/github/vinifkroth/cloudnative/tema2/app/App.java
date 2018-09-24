package com.github.vinifkroth.cloudnative.tema2.app;

import com.github.vinifkroth.cloudnative.tema2.model.Pet;
import com.github.vinifkroth.cloudnative.tema2.modules.ServiceModule;
import com.github.vinifkroth.cloudnative.tema2.modules.UtilModule;
import com.github.vinifkroth.cloudnative.tema2.service.PetStore;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ServiceModule(), new UtilModule());
		PetStore petStore = injector.getInstance(PetStore.class);
		petStore.addPet("toby", "doggo", 10);
		petStore.addPet("mike", "catto", 2);
		petStore.addPet("roger", "birdie", 12);
		petStore.addPet("tom", "turtle", 30);
		
		
		System.out.println(petStore.washPet(true, true, "1"));
		System.out.println(petStore.trimHair(true, "1"));
		System.out.println(petStore.washPet(false, false, "4"));
		System.out.println("Service history list: ");
		for (String string : petStore.getHistory()) {
			System.out.println(string);
		}
		System.out.println("Finding pet with the age of 10");
		for(Object object : petStore.getPetByAge(10)) {
			System.out.println(object.toString());
		}
		petStore.removePetById("2");
		System.out.println("Top 10 revenue pets");
		for(Pet pet : petStore.getTop10PetRevenue() ) { 
			System.out.println(pet.toString());
		}
	}
}
