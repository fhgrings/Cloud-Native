package Map;

import SystemOptions.RemovePet;
import SystemOptions.SearchPet;
import SystemOptions.SystemOption;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class MapSystemOption {
    public Map<Integer, SystemOption> mapSystemOption = new HashMap<>();

    public Map<Integer,SystemOption> getMapSystemOption() {
        mapSystemOption.put(1,new RemovePet());
        mapSystemOption.put(2,new SearchPet());
        return mapSystemOption;
    }





}
