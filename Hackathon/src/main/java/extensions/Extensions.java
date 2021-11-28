package extensions;

import Utillties.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public abstract class Extensions extends CommonOps {
    @Step ("SendKeys")
    public abstract void sendKeys(WebElement elem,String key);
    @Step ("click")
    public abstract void click(WebElement elem);
}
