package service;

import model.Pet;

public class WaterBath implements Service {
    private static final double WATER_BATH_PERFUME_COST = 15;
    private static final double WATER_BATH_NO_PERFUME_COST = 10;

    @Override
    public String execute(boolean perfume, Pet pet) {
        if(perfume) {
            pet.addRevenue(WATER_BATH_PERFUME_COST);
            System.out.println("Water bath with perfume");
            return "Water bath with perfume";
        }
        else {
            pet.addRevenue(WATER_BATH_NO_PERFUME_COST);
            System.out.println("Water bath with no perfume");
            return "Water bath with no perfume";
        }
    }

}
