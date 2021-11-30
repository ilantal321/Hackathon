package unitConvertorTest;

import Utillties.CommonOps;
import org.testng.annotations.Test;
import workFlows.MobileFlows;

public class unitConvertorTest extends CommonOps {
    @Test
    public void basicWeightSection(){
        MobileFlows.basicWeightSection();
    }

    @Test
    public void livingTempSection(){
        MobileFlows.livingTempSection();
    }

    @Test
    public void LivingCurrencySection(){
        MobileFlows.LivingCurrencySection();
    }
}
