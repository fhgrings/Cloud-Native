package App;

import Config.GuiceModule;
import Model.EnumOperations;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        PetShop petShop = injector.getInstance(PetShop.class);

        petShop.addPet(1,"Rex","Pitbull");
        petShop.addPet(2,"Frida","Rottweiler");
        petShop.addPet(3,"Lara","German Sheperd");
        petShop.addPet(4,"Tobi","NoN");
        petShop.addPet(5,"Dark","Doberman");
        petShop.addPet(6,"Pit","Bird");
        petShop.addPet(7,"Bidu","Belga Sheperd");
        petShop.addPet(8,"Toto","Eagle");
        petShop.addPet(9,"Pirula","Pintcher");
        petShop.addPet(10,"Tom","Dog");
        petShop.addPet(11,"Kaka","Cat");
        petShop.addPet(11,"Chico","Cat");
        petShop.addPet(11,"Chico","Cat");

        System.out.println("\n\n ====List Pets Names by ID====");
        petShop.systemOptions(EnumOperations.SEARCH_PET,1);
        petShop.systemOptions(EnumOperations.SEARCH_PET,2);
        System.out.println("\n");

        petShop.systemOptions(EnumOperations.REMOVE_PET,2);
        petShop.systemOptions(EnumOperations.SEARCH_PET,2);

        System.out.println("\n\n ===Services====");

        petShop.service(EnumOperations.DRY_BATH,true,1);
        petShop.service(EnumOperations.DRY_BATH,true,1);
        petShop.service(EnumOperations.DRY_BATH,true,1);
        petShop.service(EnumOperations.DRY_BATH,true,3);
        petShop.service(EnumOperations.WATER_BATH,false,4);
        petShop.service(EnumOperations.WATER_BATH,false,4);
        petShop.service(EnumOperations.HAIR_CUT,true,3);

        System.out.println("\n\n ====Historic====");
        petShop.listHistoric();

        System.out.println("\n\n ====Top 10 Pets Names====");
        petShop.top10Pets();

    }
}
