package SystemOptions;

import Model.Pet;

import java.util.List;

public class RemovePet implements SystemOption {

    @Override
    public Pet execute(List<Pet> petList, int id) {
        Pet pet = new Pet();
        for(Pet findPet : petList) {
            if(findPet.getId() == id) {
                pet = findPet;
                System.out.print("Pet removed ");
            }
        }
        petList.remove(pet);
        return pet;
    }
}
