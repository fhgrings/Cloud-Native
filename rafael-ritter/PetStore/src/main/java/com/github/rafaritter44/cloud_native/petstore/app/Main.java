package com.github.rafaritter44.cloud_native.petstore.app;

import com.github.rafaritter44.cloud_native.petstore.config.*;
import com.github.rafaritter44.cloud_native.petstore.model.Pet;
import com.github.rafaritter44.cloud_native.petstore.operations.*;
import com.github.rafaritter44.cloud_native.petstore.petservices.*;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String args[]) {
        Injector injector =
                Guice.createInjector(new DryBathWithoutPerfumeModule(), new DryBathWithPerfumeModule(),
                new LongHaircutModule(), new ShortHaircutModule(), new WaterBathWithoutPerfumeModule(),
                new WaterBathWithPerfumeModule());

        OperationManager operationManager = injector.getInstance(OperationManager.class);

        DryBathWithoutPerfume dryBathWithoutPerfume = injector.getInstance(DryBathWithoutPerfume.class);
        DryBathWithPerfume dryBathWithPerfume = injector.getInstance(DryBathWithPerfume.class);
        WaterBathWithoutPerfume waterBathWithoutPerfume = injector.getInstance(WaterBathWithoutPerfume.class);
        WaterBathWithPerfume waterBathWithPerfume = injector.getInstance(WaterBathWithPerfume.class);
        ShortHaircut shortHaircut = injector.getInstance(ShortHaircut.class);
        LongHaircut longHaircut = injector.getInstance(LongHaircut.class);

        AddPet addPancho = injector.getInstance(AddPet.class);
        addPancho.setPet(new Pet("Pancho", "Pug", 5));
        AddPet addLola = injector.getInstance(AddPet.class);
        addLola.setPet(new Pet("Lola", "Pug", 3));
        AddPet addNina = injector.getInstance(AddPet.class);
        addNina.setPet(new Pet("Nina", "Pincher", 8));
        AddPet addLupita = injector.getInstance(AddPet.class);
        addLupita.setPet(new Pet("Lupita", "Pincher", 1));
        AddPet addDudu = injector.getInstance(AddPet.class);
        addDudu.setPet(new Pet("Dudu", "Pincher", 1));

        RemovePet removeLupita = injector.getInstance(RemovePet.class);
        removeLupita.setId(4);
        RemovePet removeDudu = injector.getInstance(RemovePet.class);
        removeDudu.setId(5);

        DisplayPetsByAge displayOneYearPets = injector.getInstance(DisplayPetsByAge.class);
        displayOneYearPets.setAge(1);

        PerformPetService panchoWaterBathWithPerfume = new PerformPetService(1, waterBathWithPerfume);
        PerformPetService panchoShortHaircut = new PerformPetService(1, shortHaircut);
        PerformPetService lolaDryBathWithoutPerfume = new PerformPetService(2, dryBathWithoutPerfume);
        PerformPetService lolaLongHaircut = new PerformPetService(2, longHaircut);
        PerformPetService ninaDryBathWithPerfume = new PerformPetService(3, dryBathWithPerfume);
        PerformPetService ninaWaterBathWithoutPerfume = new PerformPetService(3, waterBathWithoutPerfume);

        DisplayPetServicesHistory displayPetServicesHistory = injector.getInstance(DisplayPetServicesHistory.class);

        DisplayTop10PetRevenue displayTop10PetRevenue = injector.getInstance(DisplayTop10PetRevenue.class);

        operationManager.addOperation(addPancho);
        operationManager.addOperation(addLola);
        operationManager.addOperation(addNina);
        operationManager.addOperation(addLupita);
        operationManager.addOperation(addDudu);
        operationManager.addOperation(displayOneYearPets);
        operationManager.addOperation(removeLupita);
        operationManager.addOperation(displayOneYearPets);
        operationManager.addOperation(removeDudu);
        operationManager.addOperation(displayOneYearPets);
        operationManager.addOperation(panchoWaterBathWithPerfume);
        operationManager.addOperation(panchoShortHaircut);
        operationManager.addOperation(lolaDryBathWithoutPerfume);
        operationManager.addOperation(lolaLongHaircut);
        operationManager.addOperation(ninaDryBathWithPerfume);
        operationManager.addOperation(ninaWaterBathWithoutPerfume);
        operationManager.addOperation(displayPetServicesHistory);
        operationManager.addOperation(displayTop10PetRevenue);

        operationManager.executeOperations();
    }

}
