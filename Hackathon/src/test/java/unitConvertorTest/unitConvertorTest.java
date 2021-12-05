package unitConvertorTest;

import Utillties.CommonOps;
import Utillties.Verification;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import workFlows.MobileFlows;
import static Utillties.ManageTestValuesFile.getData;
public class unitConvertorTest extends CommonOps {
    @Test(priority = 1,description = "check weight function")
    @Description("check weight function on appium mobile")
    public void test1_basicWeightSection(){
        MobileFlows.basicWeightSection();
        Verification.verifyStrings(basicWeightSection.weight_ozResult.getText(),getData("OZResult"));
    }

    @Test(priority = 2,description = "check weight function")
    @Description("check temperature function on appium mobile")
    public void test2_livingTempSection(){
        MobileFlows.livingTempSection();
        Verification.verifyStrings(livingTempSection.living_cTemp.getText(),getData("TempResult"));

    }

    @Test(priority = 3,description = "check weight function")
    @Description("check currency function on appium mobile")
    public void test3_LivingCurrencySection(){
        MobileFlows.LivingCurrencySection();
        Verification.verifyNotEqual(livingCurrencySection.getTxt_INRResult().getText(),getData("CurrencyResult"));
    }
}
