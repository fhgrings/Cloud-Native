package Historic;

import Model.Pet;

import java.util.Collections;
import java.util.List;

public class Top10 implements Historic{

    @Override
    public String execute(List<Pet> petList) {
        int counter =0;
        Collections.sort(petList);
            for(Pet pet : petList) {
                if (counter < 10) {
                System.out.println(pet.toString() + " Revenue: " + pet.getRevenue());
                counter++;
            }

        }
        return null;
    }
}
