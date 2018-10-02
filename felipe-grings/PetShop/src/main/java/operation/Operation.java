package operation;

import model.Pet;

import java.util.List;

public interface Operation {
    Pet execute(List<Pet> petList, int idPet);
}
