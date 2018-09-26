package Config;

import Map.MapSystemOption;
import Services.DryBath;
import Services.HairCut;
import Services.WaterBath;
import SystemOptions.AddPet;
import SystemOptions.RemovePet;
import SystemOptions.SearchPet;
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
        bind(MapSystemOption.class);


    }
}
