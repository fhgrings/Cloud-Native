package com.github.fhgrings.petshop.operation;

import com.github.fhgrings.petshop.model.Pet;

import java.util.List;

public class SearchPet implements Operation {

    @Override
    public Pet execute(List<Pet> petList, int idPet) {
        for(Pet pet : petList) {
            if(pet.getId() == idPet) {
                return pet;
            }
        }
        return null;
    }
}
