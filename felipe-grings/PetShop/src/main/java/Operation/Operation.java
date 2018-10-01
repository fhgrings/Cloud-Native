package Operation;

import Model.Pet;

import java.util.List;

public interface Operation {
    Pet execute(List<Pet> petList, int idPet);
}
