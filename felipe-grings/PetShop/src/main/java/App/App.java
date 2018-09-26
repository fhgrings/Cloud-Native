package App;

import Config.GuiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        PetShop petStore = injector.getInstance(PetShop.class);

        petStore.addPet(1,"Rex","Pitbull");
        petStore.addPet(2,"Frida","Rottweiler");
        petStore.addPet(3,"Lara","German Sheperd");
        petStore.addPet(4,"Tobi","NoN");
        petStore.addPet(5,"Dark","Doberman");
        petStore.addPet(6,"Pit","Bird");
        petStore.addPet(7,"Bidu","Belga Sheperd");
        petStore.addPet(8,"Toto","Eagle");
        petStore.addPet(9,"Pirula","Pintcher");
        petStore.addPet(10,"Tom","Dog");
        petStore.addPet(11,"Kaka","Cat");
        petStore.addPet(11,"Chico","Cat");
        petStore.addPet(11,"Chico","Cat");

        System.out.println("\n\n ====List Pets Names by ID====");
        petStore.systemOptions(2,1);
        petStore.systemOptions(2,2);
        System.out.println("\n");

        petStore.systemOptions(1,2);
        petStore.systemOptions(2,2);

        System.out.println("\n\n ===Services====");

        petStore.service(1,true,1);
        petStore.service(1,true,1);
        petStore.service(1,true,1);
        petStore.service(1,true,3);
        petStore.service(2,false,4);
        petStore.service(2,false,4);
        petStore.service(3,true,3);

        System.out.println("\n\n ====Historic====");
        petStore.historic(1);

        System.out.println("\n\n ====Top 10 Pets Names====");
        petStore.historic(2);

    }
}
