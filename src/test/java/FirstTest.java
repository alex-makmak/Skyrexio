import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {

    public String trialCode(int number) {
        if (number == 25) return "M";
        if (number == 15) return "TSyyM";
        return "FAIL";
    }

    @Test
    public void checkTrialNumber2() {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "M");
    }

    @Test
    public void checkTrialNumber3() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "TSyyM");
    }

    @Test
    public void checkTrialNumber43() {
        String actualResult = trialCode(7);
        assertEquals(actualResult, "FAIL");
    }
}