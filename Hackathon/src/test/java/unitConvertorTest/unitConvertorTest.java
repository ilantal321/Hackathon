package unitConvertorTest;

import Utillties.CommonOps;
import org.testng.annotations.Test;
import workFlows.MobileFlows;

public class unitConvertorTest extends CommonOps {
    @Test
    public void Test1basicWeightSection(){
        MobileFlows.basicWeightSection();
    }

    @Test
    public void Test2livingTempSection(){
        MobileFlows.livingTempSection();
    }

    @Test
    public void Test3LivingCurrencySection(){
        MobileFlows.LivingCurrencySection();
    }
}
