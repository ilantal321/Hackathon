package pageObjects.gafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuComponent {
    @FindBy(xpath = " //a[@href='/datasources']")
    private WebElement svg_Configuration;
    @FindBy(xpath = "//*[@href='/plugins']")
    private WebElement a_plugins;

    public WebElement getA_plugins() {
        return a_plugins;
    }

    public WebElement getSvg_Configuration() {
        return svg_Configuration;
    }
}
