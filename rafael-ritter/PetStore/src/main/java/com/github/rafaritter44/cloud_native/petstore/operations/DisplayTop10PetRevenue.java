package com.github.rafaritter44.cloud_native.petstore.operations;

import com.github.rafaritter44.cloud_native.petstore.petservices.PetStore;
import com.google.inject.Inject;

public class DisplayTop10PetRevenue implements Operation {

    private PetStore petStore;

    @Inject
    public DisplayTop10PetRevenue(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public void execute() {
        System.out.println(petStore.displayTop10PetRevenue());
    }

}
