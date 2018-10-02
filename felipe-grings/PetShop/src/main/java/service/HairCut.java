package service;

import model.Pet;

public class HairCut implements Service {
    private static final double HAIR_CUT_COST = 5;

    @Override
    public String execute(boolean longCut, Pet pet) {
        if(longCut) {
            System.out.println("Long Hair Cut");
            pet.addRevenue(HAIR_CUT_COST);
            return "Long Hair Cut";
        }
        else
            System.out.println("Short hair Cut");
            pet.addRevenue(HAIR_CUT_COST);
        return "Short hair Cut";
    }
}
