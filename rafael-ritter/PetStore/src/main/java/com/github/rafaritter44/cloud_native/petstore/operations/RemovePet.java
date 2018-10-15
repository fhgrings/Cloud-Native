package com.github.rafaritter44.cloud_native.petstore.operations;

import com.github.rafaritter44.cloud_native.petstore.model.Pet;
import com.github.rafaritter44.cloud_native.petstore.petservices.PetStore;
import com.google.inject.Inject;

import java.util.Optional;

public class RemovePet implements Operation {

    private PetStore petStore;
    private int id;

    @Inject
    public RemovePet(PetStore petStore) {
        this.petStore = petStore;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        Optional<Pet> pet = petStore.removePet(id);
        if(pet.isPresent())
            System.out.println(pet.get().getName() + " removed");
        else
            System.out.println("Pet not found");
    }

}
