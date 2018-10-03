package com.github.rafaritter44.cloud_native.petstore.operations;

import com.github.rafaritter44.cloud_native.petstore.model.Pet;
import com.github.rafaritter44.cloud_native.petstore.petservices.PetStore;
import com.google.inject.Inject;

public class AddPet implements Operation {

    private PetStore petStore;
    private Pet pet;

    @Inject
    public AddPet(PetStore petStore) {
        this.petStore = petStore;
    }

    public void setPet(Pet pet) { this.pet = pet; }

    @Override
    public void execute() {
        petStore.addPet(pet);
        System.out.println(pet.getName() + " added");
    }

}
