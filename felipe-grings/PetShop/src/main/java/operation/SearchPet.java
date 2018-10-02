package operation;

import model.Pet;

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
