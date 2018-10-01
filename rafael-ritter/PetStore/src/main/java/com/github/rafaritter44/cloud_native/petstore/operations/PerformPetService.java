package com.github.rafaritter44.cloud_native.petstore.operations;

import com.github.rafaritter44.cloud_native.petstore.petservices.PetService;

public class PerformPetService implements Operation {

    private int id;
    private PetService petService;

    public PerformPetService(int id, PetService petService) {
        this.id = id;
        this.petService = petService;
    }


    @Override
    public void execute() {
        petService.perform(id);
    }

}
