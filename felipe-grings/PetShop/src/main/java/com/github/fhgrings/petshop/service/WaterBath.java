package com.github.fhgrings.petshop.service;

import com.github.fhgrings.petshop.model.Pet;

public class WaterBath implements Service {
    private static final double WATER_BATH_PERFUME_COST = 15;
    private static final double WATER_BATH_NO_PERFUME_COST = 10;

    @Override
    public String execute(boolean perfume, Pet pet) {
        if(perfume) {
            pet.addRevenue(WATER_BATH_PERFUME_COST);
            return "Water bath with perfume";
        }
        else {
            pet.addRevenue(WATER_BATH_NO_PERFUME_COST);
            return "Water bath with no perfume";
        }
    }

}
