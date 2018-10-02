package operation;

import model.Pet;

import java.util.List;

public class RemovePet implements Operation {

    @Override
    public Pet execute(List<Pet> petList, int idPet) {
        Pet pet = new Pet();
        for(Pet findPet : petList) {
            if(findPet.getId() == idPet) {
                pet = findPet;
                System.out.print("Pet removed ");
                break;
            }
        }
        petList.remove(pet);
        return pet;
    }
}
