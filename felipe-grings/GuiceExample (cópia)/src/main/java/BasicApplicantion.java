import com.google.inject.Inject;

public class BasicApplicantion {
    private final CheckOutService checkOutService;
    @Inject
    public BasicApplicantion(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    void start() {
        checkOutService.checkout(100.0D);
    }
}
