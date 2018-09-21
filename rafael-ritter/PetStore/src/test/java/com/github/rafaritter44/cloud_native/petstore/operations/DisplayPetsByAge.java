package com.github.rafaritter44.cloud_native.petstore.operations;

import com.github.rafaritter44.cloud_native.petstore.petservices.PetStore;
import com.google.inject.Inject;

public class DisplayPetsByAge implements Operation {

    private PetStore petStore;
    private int age;

    @Inject
    public DisplayPetsByAge(PetStore petStore) {
        this.petStore = petStore;
    }

    public void setAge(int age) { this.age = age; }

    @Override
    public void execute() {
        System.out.println(petStore.displayPetsByAge(age));
    }

}
