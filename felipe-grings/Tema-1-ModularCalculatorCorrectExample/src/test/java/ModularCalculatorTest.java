import com.github.fhgrings.calculator.Config.AppConfig;
import com.github.fhgrings.calculator.Operations.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})

public class ModularCalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void shouldSaveOnMemory() {
        calculator.finishCalculation(3, 6, "+");

        Assert.assertEquals(9.0+"\n", calculator.getMapHistory());
    }

    @Test
    public void shouldSum(){
        Assert.assertEquals(4.2,calculator.finishCalculation(1.2,3,"+"), 0);
    }

    @Test
    public void shouldSub(){
        Assert.assertEquals(-0.2,calculator.finishCalculation(2.2,2.4,"-"),0);
    }

    @Test
    public void shouldMultiply(){
        Assert.assertEquals(6,calculator.finishCalculation(2,3,"*"),0);
    }

    @Test
    public void shouldDiv(){
        Assert.assertEquals(1.0,calculator.finishCalculation(3,3,"/"),0);
    }

}
