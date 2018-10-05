package com.github.fhgrings.petshop.operation;

import com.github.fhgrings.petshop.model.Pet;

import java.util.List;

public interface Operation {
    Pet execute(List<Pet> petList, int idPet);
}
