package com.github.fhgrings.petshop.app;

import com.github.fhgrings.petshop.config.GuiceModule;
import com.github.fhgrings.petshop.model.EnumOperations;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        PetShop petShop = injector.getInstance(PetShop.class);

        System.out.println(petShop.addPet(1,"Rex","Pitbull") + " Added");
        System.out.println(petShop.addPet(2,"Frida","Rottweiler") + " Added");
        System.out.println(petShop.addPet(3,"Lara","German Sheperd") + " Added");
        System.out.println(petShop.addPet(4,"Tobi","NoN") + " Added");
        System.out.println(petShop.addPet(5,"Dark","Doberman") + " Added");
        System.out.println(petShop.addPet(6,"Pit","Bird") + " Added");
        System.out.println(petShop.addPet(7,"Bidu","Belga Sheperd") + " Added");
        System.out.println(petShop.addPet(8,"Toto","Eagle") + " Added");
        System.out.println(petShop.addPet(9,"Pirula","Pintcher") + " Added");
        System.out.println(petShop.addPet(10,"Tom","Dog") + " Added");
        System.out.println(petShop.addPet(11,"Kaka","Cat") + " Added");
        System.out.println(petShop.addPet(11,"Chico","Cat") + " Added");
        System.out.println(petShop.addPet(11,"Chico","Cat") + " Added");

        System.out.println("\n\n ====List Pets Names by ID====");
        try {
            System.out.println(petShop.operation(EnumOperations.SEARCH_PET,1));
            System.out.println(petShop.operation(EnumOperations.SEARCH_PET,2));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("\n");

        try {
            System.out.println(petShop.operation(EnumOperations.REMOVE_PET,2) + " Removed");
            System.out.println(petShop.operation(EnumOperations.SEARCH_PET,2));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n\n ===Service====");

        try {
            System.out.println(petShop.service(EnumOperations.DRY_BATH,true,1));
            System.out.println(petShop.service(EnumOperations.DRY_BATH,true,1));
            System.out.println(petShop.service(EnumOperations.DRY_BATH,true,1));
            System.out.println(petShop.service(EnumOperations.DRY_BATH,true,3));
            System.out.println(petShop.service(EnumOperations.WATER_BATH,false,4));
            System.out.println(petShop.service(EnumOperations.WATER_BATH,false,4));
            System.out.println(petShop.service(EnumOperations.HAIR_CUT,true,3));
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("\n\n ====Historic====");
        System.out.println(petShop.listHistoric());

        System.out.println("\n\n ====Top 10 Pets Names====");
        System.out.println(petShop.top10Pets());

    }
}
