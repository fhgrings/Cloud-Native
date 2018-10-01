package com.github.rafaritter44.cloud_native.petstore.petservices;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class DryBathWithoutPerfume implements PetService {

    private PetStore petStore;
    private int price;

    @Inject
    public DryBathWithoutPerfume(PetStore petStore, @Named("DryBathWithoutPerfumePrice") int price) {
        this.petStore = petStore;
        this.price = price;
    }

    @Override
    public void perform(int id) {
        petStore.doDryBathWithoutPerfume(id, this);
    }

    @Override
    public int charge() {
        return price;
    }

}
