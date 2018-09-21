import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.Map;
import java.util.Random;

public class DiscountGuiceProvidor implements Provider<Discountable> {
    private final Map<Integer, Discountable> map;
    private final Random random;


    @Inject
    public DiscountGuiceProvidor(Map<Integer, Discountable> map, Random random) {
        this.map = map;
        this.random = random;
    }

    @Override
    public Discountable get() {
        return map.get(random.nextInt(map.size()));
    }

}
