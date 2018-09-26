package Historic;

import Model.Pet;
import java.util.List;

public class ListHistoric implements Historic{

    @Override
    public String execute(List<Pet> petList) {
        for (Pet pet : petList) {
            for(String historic : pet.getPetService())
            System.out.println("Name: " + pet.getName() + "-  " + historic);
        }
        return null;
    }
}
