package extensions;

import Utillties.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class Extensions extends CommonOps {
    @Step ("SendKeys")
    public static void sendKeys(WebElement elem,String key){
        elem.sendKeys(key);
    }
    @Step ("click")
    public static void click(WebElement elem){
        elem.click();
    }
}
