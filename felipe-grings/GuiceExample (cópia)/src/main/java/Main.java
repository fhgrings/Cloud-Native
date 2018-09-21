import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector guice = Guice.createInjector(new DiscountGuiceModule());
        BasicApplicantion app = guice.getInstance(BasicApplicantion.class);

        app.start();

    }
}
