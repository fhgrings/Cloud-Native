package Map;

import Services.DryBath;
import Services.HairCut;
import Services.Service;
import Services.WaterBath;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class MapServices {
    public Map<Integer, Service> mapService = new HashMap<>();

    public Map<Integer,Service> getMapService() {
        mapService.put(1, new DryBath());
        mapService.put(2, new WaterBath());
        mapService.put(3, new HairCut());
        return mapService;
    }

}
