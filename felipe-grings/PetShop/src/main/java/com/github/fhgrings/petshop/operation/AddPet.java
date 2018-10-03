package com.github.fhgrings.petshop.operation;

import com.github.fhgrings.petshop.model.Pet;

import java.util.List;

public class AddPet{
    int idPetCounter;

    public int getIdPetCounter() {
        return idPetCounter;
    }

    public void setIdPetCounter(int idPetCounter) {
        this.idPetCounter = idPetCounter;
    }

    public Pet execute(List<Pet> petList,int age, String name, String race) {
        idPetCounter++;
        Pet pet = new Pet(idPetCounter,age,race,name);
        petList.add(pet);
        return pet;
    }
}
