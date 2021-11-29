package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class GrafanaUIActions extends Extensions {
    @Step("SendKeys")
    public void sendKeys(WebElement elem, String key){
        elem.sendKeys(key);
    }
    @Step ("click")
    public  void click(WebElement elem){
        elem.click();
    }
}
