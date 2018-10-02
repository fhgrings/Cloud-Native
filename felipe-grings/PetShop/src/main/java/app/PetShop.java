package app;

import model.EnumOperations;
import model.Pet;
import operation.AddPet;
import operation.Operation;
import service.DryBath;
import service.HairCut;
import service.Service;
import service.WaterBath;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.*;

import operation.*;

@Singleton
public class PetShop {
    private Map<Enum, Service> mapService;
    private AddPet addPet;
    private List<Pet> petList;
    public Map<Enum, Operation> mapSystemOption;


    @Inject
    public PetShop() {
        addPet = new AddPet();
        petList = new ArrayList<>();

        mapSystemOption = new HashMap<Enum, Operation>();
        mapSystemOption.put(EnumOperations.REMOVE_PET,new RemovePet());
        mapSystemOption.put(EnumOperations.SEARCH_PET,new SearchPet());

        mapService = new HashMap<Enum, Service>();
        mapService.put(EnumOperations.DRY_BATH, new DryBath());
        mapService.put(EnumOperations.WATER_BATH, new WaterBath());
        mapService.put(EnumOperations.HAIR_CUT, new HairCut());
    }

    public String systemOptions(Enum option, int idPet) {
        if(option == EnumOperations.REMOVE_PET || option == EnumOperations.SEARCH_PET) {
            try {
                String result = mapSystemOption.get(option).execute(petList,idPet).toString();
                System.out.println(result);
                return result;
            } catch (Exception e) {
                System.out.println("Pet ID not found");
                return "Pet ID not found";
            }
        } else
            System.out.println("Option not found");
        return "Option not found";
    }

    public boolean addPet(int age, String name, String race) {
        addPet.execute(petList,age,name,race);
        return true;
    }

    public boolean service(EnumOperations option, boolean longCut, int idPet) {
        if(option == EnumOperations.WATER_BATH || option == EnumOperations.DRY_BATH || option == EnumOperations.HAIR_CUT) {
            try {
                Pet pet = mapSystemOption.get(EnumOperations.SEARCH_PET).execute(petList,idPet);
                pet.setPetService(mapService.get(option).execute(longCut, pet));
                return true;
            } catch (Exception e) {
                System.out.println("Pet ID not found");
            }
        } else
            System.out.println("Option not found");
        return false;
    }

    public String listHistoric() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Pet pet : petList) {
            for(String historic : pet.getPetService())
                stringBuffer.append("Name: " + pet.getName() + "-  " + historic + "\n");
        }
        System.out.println(stringBuffer);
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
        System.out.println(stringBuffer);
        return stringBuffer.toString();
    }

}
