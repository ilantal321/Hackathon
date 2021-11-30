package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertTrue;

public class CalculatorPage {
    @FindBy(how= How.NAME,using = "Nine")
    private WebElement btn_Nine;
    @FindBy(how= How.NAME,using = "Two")
    private WebElement btn_Two;
    @FindBy(how= How.NAME,using = "Five")
    private WebElement btn_Five;
    @FindBy(how= How.NAME,using = "One")
    private WebElement btn_One;
    @FindBy(how= How.NAME,using = "Plus")
    private WebElement btn_Plus;
    @FindBy(how= How.NAME,using = "Minus")
    private WebElement btn_Minus;
    @FindBy(how= How.NAME,using = "Divide by")
    private WebElement btn_DivideBy;
    @FindBy(how= How.NAME,using = "Multiply by")
    private WebElement btn_MultiplyBy;
    @FindBy(how= How.NAME,using = "Equals")
    private WebElement btn_Equals;
    @FindBy(how= How.XPATH,using = "//*[@AutomationId='CalculatorResults']")
    private WebElement btn_Results;

    public WebElement getBtn_Nine() {
        return btn_Nine;
    }

    public WebElement getBtn_Two() {
        return btn_Two;
    }

    public WebElement getBtn_Five() {
        return btn_Five;
    }

    public WebElement getBtn_One() {
        return btn_One;
    }

    public WebElement getBtn_Plus() {
        return btn_Plus;
    }

    public WebElement getBtn_Minus() {
        return btn_Minus;
    }

    public WebElement getBtn_DivideBy() {
        return btn_DivideBy;
    }

    public WebElement getBtn_MultiplyBy() {
        return btn_MultiplyBy;
    }

    public WebElement getBtn_Equals() {
        return btn_Equals;
    }

    public WebElement getBtn_Results() {
        return btn_Results;
    }

}
