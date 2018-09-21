import com.google.inject.multibindings.MapBinder;
import java.util.Random;

public class DiscountGuiceModule extends  com.google.inject.AbstractModule {


    @Override
    protected void configure() {

       MapBinder<Integer, Discountable> map = MapBinder.newMapBinder(binder(),Integer.class, Discountable.class);
       map.addBinding(1).to(EarlyBirdDiscount.class);
       map.addBinding(2).to(NightOwlDiscount.class);

       bind(Random.class).toInstance(new Random());

       bind(Discountable.class).toProvider(DiscountGuiceProvidor.class);
        //bind(Discountable.class).to(EarlyBirdDiscount.class);
    }

}
