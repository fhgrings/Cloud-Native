import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckOutService {

    private final Discountable discountable;
    @Inject
    public CheckOutService(Discountable discountable) {
        this.discountable = discountable;

    }

    public double checkout(double shoppingCartTotal) {
        double discount = discountable.getDiscount();

        double totalAfterDiscount = shoppingCartTotal - (shoppingCartTotal * discount);
        System.out.println("Shopping cart iniatilly " + shoppingCartTotal + " with a discount of  " + discount * shoppingCartTotal + " the total was " + totalAfterDiscount);
        return totalAfterDiscount;
   }


}
