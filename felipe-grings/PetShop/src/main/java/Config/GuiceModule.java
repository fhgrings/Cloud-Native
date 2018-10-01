package Config;

import Services.DryBath;
import Services.HairCut;
import Services.WaterBath;
import Operation.AddPet;
import Operation.RemovePet;
import Operation.SearchPet;
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
