package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PluginsPage {
    @FindBy(xpath = "//input[@class='css-1064hy6-input-input']")
    private WebElement input_searchPlugins;

    public WebElement getInput_searchPlugins() {
        return input_searchPlugins;
    }
}
