package SystemOptions;

import Model.Pet;

import java.util.List;

public class SearchPet implements SystemOption {

    @Override
    public Pet execute(List<Pet> petList, int id) {
        for(Pet pet : petList) {
            if(pet.getId() == id) {
                return pet;
            }
        }
        System.out.println("pet nao encontrado");
        return null;
    }
}
