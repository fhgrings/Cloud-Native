package com.github.rafaritter44.cloud_native.petstore.operations;

import com.github.rafaritter44.cloud_native.petstore.petservices.PetStore;
import com.google.inject.Inject;

public class DisplayPetServicesHistory implements Operation {

    private PetStore petStore;

    @Inject
    public DisplayPetServicesHistory(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public void execute() {
        System.out.println(petStore.displayPetServicesHistory());
    }

}
