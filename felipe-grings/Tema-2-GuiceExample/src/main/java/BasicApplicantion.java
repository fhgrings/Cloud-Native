import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class BasicApplicantion {
    private final CheckOutService checkOutService;

    @Inject
    public BasicApplicantion(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    void start() {
        checkOutService.checkout(100.0D);
    }

    public static void main(String[] args){
        Injector guice = Guice.createInjector(new DiscountGuiceModule());
        BasicApplicantion app = guice.getInstance(BasicApplicantion.class);

        app.start();

    }
}
