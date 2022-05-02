package practice5.UnitTestCalc;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static practice1.Calculator.substract;

public class CalcMinusTest {
    @Test
    @Parameters({ "a", "b" })
    void calcMinusTest(Integer a, Integer b){
        Assert.assertEquals(substract(a, b),a - b," invalid substract() operation");
    }
}
