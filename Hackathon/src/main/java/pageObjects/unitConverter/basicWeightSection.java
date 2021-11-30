package pageObjects.unitConverter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class basicWeightSection {
    private final AndroidDriver<AndroidElement> driver;

    public basicWeightSection(AndroidDriver<AndroidElement> driver) {
       this.driver = driver;
       PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @FindBy(id = "text_weight")
    public AndroidElement txt_weight;

    @FindBy(xpath = "//*[@id='tab0_input']")
    public AndroidElement weight_input;

    @FindBy(xpath = "//*[@id='tab0_num2']")
    public AndroidElement weight_number2;

    @FindBy(xpath = "//*[@id='tab0_num1']")
    public AndroidElement weight_number1;

    @FindBy(xpath = "//*[@id='tab0_selector']")
    public AndroidElement weight_selector;

    @FindBy(xpath = "//*[@text='lb (pound)']")
    public AndroidElement weight_lb;

    @FindBy(xpath = "//*[@text='192']")
    public AndroidElement weight_ozResult;




    public AndroidElement click_weightSection() {
        return txt_weight;
    }

    public AndroidElement getWeight_input() {
        return weight_input;
    }

    public AndroidElement getWeight_number2() {
        return weight_number2;
    }

    public AndroidElement getWeight_number1() {
        return weight_number1;
    }

    public AndroidElement getWeight_selector() {
        return weight_selector;
    }

    public AndroidElement getWeight_lb() {
        return weight_lb;
    }

    public AndroidElement getWeight_ozResult() {
        return weight_ozResult;
    }
}
