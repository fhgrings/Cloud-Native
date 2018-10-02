package config;

import service.DryBath;
import service.HairCut;
import service.WaterBath;
import operation.AddPet;
import operation.RemovePet;
import operation.SearchPet;
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
