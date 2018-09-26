package Services;

import Model.Pet;

public class WaterBath implements Service {
    private double WaterBathPerfumeCost = 15;
    private double WaterBathNoPerfumeCost = 10;

    @Override
    public String execute(boolean perfume, Pet pet) {
        if(perfume) {
            pet.addRevenue(WaterBathPerfumeCost);
            System.out.println("Water bath with perfume");
            return "Water bath with perfume";
        }
        else {
            pet.addRevenue(WaterBathNoPerfumeCost);
            System.out.println("Water bath with no perfume");
            return "Water bath with no perfume";
        }
    }

}
