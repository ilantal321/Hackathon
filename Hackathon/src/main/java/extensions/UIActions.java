package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class UIActions extends Extensions {
    @Step("SendKeys")
    public  void sendKeys(WebElement elem, String key){
        elem.sendKeys(key);
    }
    @Step ("click")
    public  void click(WebElement elem){
        elem.click();
    }

    @Step("Edit text Input")
    public static void editInput(WebElement elem, String newName){
        actions.moveToElement(elem).click().doubleClick(elem).sendKeys(newName).sendKeys(Keys.RETURN);
        actions.build().perform();
    }

    @Step("Move to element")
    public static void moveToElement(WebElement element){
        actions.moveToElement(element).build().perform();
    }
}
