package com.github.fhgrings.petshop.service;

import com.github.fhgrings.petshop.model.Pet;

public class DryBath implements Service {
    private static final double DRY_BATH_PERFUME_COST = 5;
    private static final double DRY_BATH_NO_PERFUME_COST = 4;

    @Override
    public String execute(boolean perfume, Pet pet) {
        if(perfume) {
            pet.addRevenue(DRY_BATH_PERFUME_COST);
            return "Dry bath with perfume";
        }
        else
            pet.addRevenue(DRY_BATH_NO_PERFUME_COST);
        return "Dry bath with no perfume";
    }
}
