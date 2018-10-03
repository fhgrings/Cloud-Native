package com.github.fhgrings.petshop.app;

import com.github.fhgrings.petshop.model.*;
import com.github.fhgrings.petshop.operation.*;
import com.github.fhgrings.petshop.service.*;
import com.github.fhgrings.petshop.operation.RemovePet;
import com.github.fhgrings.petshop.operation.SearchPet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.*;

@Singleton
public class PetShop {
    private Map<Enum, Service> mapService;
    private AddPet addPet;
    private List<Pet> petList;
    private Map<Enum, Operation> mapSystemOption;


    @Inject
    public PetShop() {
        addPet = new AddPet();
        petList = new ArrayList<>();

        mapSystemOption = new HashMap<>();
        mapSystemOption.put(EnumOperations.REMOVE_PET,new RemovePet());
        mapSystemOption.put(EnumOperations.SEARCH_PET,new SearchPet());

        mapService = new HashMap<>();
        mapService.put(EnumOperations.DRY_BATH, new DryBath());
        mapService.put(EnumOperations.WATER_BATH, new WaterBath());
        mapService.put(EnumOperations.HAIR_CUT, new HairCut());
    }

    public Pet operation(Enum option, int idPet) throws Exception {
        if(option == EnumOperations.REMOVE_PET || option == EnumOperations.SEARCH_PET) {
            Pet result = mapSystemOption.get(option).execute(petList, idPet);
            return result;
        } else
            throw new Exception("ERROR: Option not found");
    }

    public Pet addPet(int age, String name, String race) {
        return addPet.execute(petList,age,name,race);
    }

    public String service(EnumOperations option, boolean longCut, int idPet) throws Exception {
        if(option == EnumOperations.WATER_BATH || option == EnumOperations.DRY_BATH || option == EnumOperations.HAIR_CUT) {
            Pet pet = mapSystemOption.get(EnumOperations.SEARCH_PET).execute(petList,idPet);
            return pet.setPetService(mapService.get(option).execute(longCut, pet));
        } else
            throw new Exception("ERROR: Option not found");
    }

    public String listHistoric() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Pet pet : petList) {
            for(String historic : pet.getPetService())
                stringBuffer.append("Name: " + pet.getName() + "-  " + historic + "\n");
        }
        return stringBuffer.toString();
    }

    public String top10Pets() {
        int counter=0;
        StringBuffer stringBuffer = new StringBuffer();
        Collections.sort(petList);
        for(Pet pet : petList) {
            if (counter < 10) {
                stringBuffer.append(pet.toString() + " Revenue: " + pet.getRevenue() + "\n");
                counter++;
            }
        }
        return stringBuffer.toString();
    }

}
