package Services;

import Model.Pet;

public class DryBath implements Service {
    private double DryBathPerfumeCost = 5;
    private double DryBathNoPerfumeCost = 4;

    @Override
    public String execute(boolean perfume, Pet pet) {
        if(perfume) {
            pet.addRevenue(DryBathPerfumeCost);
            System.out.println("Dry bath with perfume");
            return "Dry bath with perfume";
        }
        else
            System.out.println("Dry bath with no perfume");
            pet.addRevenue(DryBathNoPerfumeCost);
        return "Dry bath with no perfume";
    }
}
