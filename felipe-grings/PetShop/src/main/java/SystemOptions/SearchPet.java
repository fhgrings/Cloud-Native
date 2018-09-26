package SystemOptions;

import Model.Pet;

import java.util.List;

public class SearchPet implements SystemOption {

    @Override
    public Pet execute(List<Pet> petList, int idPet) {
        for(Pet pet : petList) {
            if(pet.getId() == idPet) {
                return pet;
            }
        }
        System.out.println("pet nao encontrado");
        return null;
    }
}
