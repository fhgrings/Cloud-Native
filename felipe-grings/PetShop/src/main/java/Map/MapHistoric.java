package Map;

import Historic.Historic;
import Historic.ListHistoric;
import Historic.Top10;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class MapHistoric {
    public Map<Integer, Historic> mapHistoric = new HashMap<>();

    public Map<Integer,Historic> getMapHistoric() {
        mapHistoric.put(1,new ListHistoric());
        mapHistoric.put(2,new Top10());
        return mapHistoric;
    }
}
