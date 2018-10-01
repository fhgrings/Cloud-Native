package Operation;

import Model.Pet;

import java.util.List;

public class AddPet{
    int idPetCounter;

    public int getIdPetCounter() {
        return idPetCounter;
    }

    public void setIdPetCounter(int idPetCounter) {
        this.idPetCounter = idPetCounter;
    }

    public AddPet() {
        idPetCounter =0;
    }

    public Pet execute(List<Pet> petList,int age, String name, String race) {
        idPetCounter++;
        Pet pet = new Pet(idPetCounter,age,race,name);
        if(petList.add(pet))
            System.out.println(pet + " Added");
        return pet;
    }
}
