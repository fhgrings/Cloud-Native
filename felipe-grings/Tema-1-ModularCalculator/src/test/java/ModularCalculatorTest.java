import com.github.fhgrings.calculator.Config.AppConfig;
import com.github.fhgrings.calculator.Operations.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static jdk.nashorn.internal.objects.Global.Infinity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})

public class ModularCalculatorTest {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void shouldSaveOnMemory() throws Exception {
        calculator.calculate(3, 6, "sum");
        calculator.calculate(3, 0, "sum");
        calculator.calculate(3, 3, "sum");

        Assert.assertEquals(9.0+"\n"+3.0+"\n"+6.0+"\n", calculator.getMapHistory());
    }

    @Test
    public void shouldSum() throws Exception {
        Assert.assertEquals(4.2,calculator.calculate(1.2,3,"sum"), 0);
    }

    @Test
    public void shouldSub() throws Exception {
        Assert.assertEquals(-0.2,calculator.calculate(2.2,2.4,"sub"),0);
    }

    @Test
    public void shouldMultiply() throws Exception {
        Assert.assertEquals(6,calculator.calculate(2,3,"mult"),0);
    }

    @Test
    public void shouldDiv() throws Exception {
        Assert.assertEquals(1.0,calculator.calculate(3,3,"div"),0);
    }

    @Test
    public void shouldDivBy0() throws Exception {
        Assert.assertEquals(Infinity,calculator.calculate(3,0,"div"),0);
    }

    @Test
    public void shouldSubBug() throws Exception {
        Assert.assertEquals(0.3,calculator.calculate(2.5,2.2,"sub"),0);
    }

}
