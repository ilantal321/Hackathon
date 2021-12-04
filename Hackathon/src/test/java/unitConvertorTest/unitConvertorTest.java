package unitConvertorTest;

import Utillties.CommonOps;
import Utillties.Verification;
import org.testng.Assert;
import org.testng.annotations.Test;
import workFlows.MobileFlows;

public class unitConvertorTest extends CommonOps {
    @Test
    public void test1_basicWeightSection(){
        MobileFlows.basicWeightSection();
        Verification.verifyStrings(basicWeightSection.weight_ozResult.getText(),getData("OZResult"));
    }

    @Test
    public void test2_livingTempSection(){
        MobileFlows.livingTempSection();
        Verification.verifyStrings(livingTempSection.living_cTemp.getText(),getData("TempResult"));

    }

    @Test
    public void test3_LivingCurrencySection(){
        MobileFlows.LivingCurrencySection();
        Verification.verifyNotEqual(livingCurrencySection.getTxt_INRResult().getText(),getData("CurrencyResult"));
    }
}
