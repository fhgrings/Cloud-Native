package SystemOptions;

import Model.Pet;

import java.util.List;

public interface SystemOption {
    Pet execute(List<Pet> petList, int id);
}
