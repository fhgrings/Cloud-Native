package Services;

import Model.Pet;

public class HairCut implements Service {
    private double hairCutCost = 2;

    @Override
    public String execute(boolean longCut, Pet pet) {
        if(longCut) {
            System.out.println("long Hair Cut");
            pet.addRevenue(hairCutCost);
            return "long Hair Cut";
        }
        else
            System.out.println("Short hair Cut");
            pet.addRevenue(hairCutCost);
        return "Short hair Cut";
    }
}
