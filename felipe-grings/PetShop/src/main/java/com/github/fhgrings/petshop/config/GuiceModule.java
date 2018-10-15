package com.github.fhgrings.petshop.config;

import com.github.fhgrings.petshop.service.DryBath;
import com.github.fhgrings.petshop.service.HairCut;
import com.github.fhgrings.petshop.service.WaterBath;
import com.github.fhgrings.petshop.operation.AddPet;
import com.github.fhgrings.petshop.operation.RemovePet;
import com.github.fhgrings.petshop.operation.SearchPet;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AddPet.class);
        bind(RemovePet.class);
        bind(SearchPet.class);
        bind(DryBath.class);
        bind(HairCut.class);
        bind(WaterBath.class);
    }
}
