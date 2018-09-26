package App;

import Map.MapHistoric;
import Map.MapServices;
import Map.MapSystemOption;
import Model.Pet;
import SystemOptions.AddPet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.*;

@Singleton
public class PetShop {
    private MapHistoric mapHistoric;
    private MapServices mapServices;
    private MapSystemOption mapSystemOption;
    private AddPet addPet;
    private List<Pet> petList;


    @Inject
    public PetShop(MapHistoric mapHistoric, MapServices mapServices, MapSystemOption mapSystemOption) {
        this.mapHistoric = mapHistoric;
        this.mapServices = mapServices;
        this.mapSystemOption = mapSystemOption;
        addPet = new AddPet();
        petList = new ArrayList<>();
    }

    public boolean systemOptions(int option, int idPet) {
        if(option == 1 || option == 2) {
            try {
                System.out.println(mapSystemOption.getMapSystemOption().get(option).execute(petList, idPet).toString());
                return true;
            } catch (Exception e) {
                System.out.println("Pet ID not found");
            }
        } else
            System.out.println("Option not found");
        return false;
    }

    public boolean addPet(int age, String name, String race) {
        addPet.execute(petList,age,name,race);
        return true;
    }

    public boolean service(int option,boolean longCut, int idPet) {
        if(option == 1 || option == 2) {
            try {
                Pet pet = mapSystemOption.getMapSystemOption().get(2).execute(petList,idPet);
                pet.setPetService(mapServices.getMapService().get(option).execute(longCut, pet));
                return true;
            } catch (Exception e) {
                System.out.println("Pet ID not found");
            }
        } else
            System.out.println("Option not found");
        return false;
    }

    public boolean historic(int option){
        if(option == 1 || option == 2) {
            mapHistoric.getMapHistoric().get(option).execute(petList);
            return true;
        }
        else
            System.out.println("Option not found");
        return false;
    }

}
