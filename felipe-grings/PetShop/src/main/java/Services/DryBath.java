package Services;

import Model.Pet;

public class DryBath implements Service {
    private static final double DRY_BATH_PERFUME_COST = 5;
    private static final double DRY_BATH_NO_PERFUME_COST = 4;

    @Override
    public String execute(boolean perfume, Pet pet) {
        if(perfume) {
            pet.addRevenue(DRY_BATH_PERFUME_COST);
            System.out.println("Dry bath with perfume");
            return "Dry bath with perfume";
        }
        else
            System.out.println("Dry bath with no perfume");
            pet.addRevenue(DRY_BATH_NO_PERFUME_COST);
        return "Dry bath with no perfume";
    }
}
