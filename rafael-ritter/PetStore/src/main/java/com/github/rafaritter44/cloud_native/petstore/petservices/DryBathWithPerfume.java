package com.github.rafaritter44.cloud_native.petstore.petservices;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class DryBathWithPerfume implements PetService {

    private PetStore petStore;
    private int price;

    @Inject
    public DryBathWithPerfume(PetStore petStore, @Named("DryBathWithPerfumePrice") int price) {
        this.petStore = petStore;
        this.price = price;
    }

    @Override
    public void perform(int id) {
        petStore.doDryBathWithPerfume(id, this);
    }

    @Override
    public int charge() {
        return price;
    }
}
