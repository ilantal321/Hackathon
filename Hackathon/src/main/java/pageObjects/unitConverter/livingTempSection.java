package pageObjects.unitConverter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class livingTempSection {
    private final AndroidDriver<AndroidElement> driver;

    public livingTempSection(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(xpath = "//*[@text='LIVING']")
    public AndroidElement living_section;

    @FindBy(id = "image_living1")
    public AndroidElement living_tempTab;

    @FindBy(xpath = "//*[@text='-1.111111']")
    public AndroidElement living_cTemp;

    public AndroidElement getLiving_section() {
        return living_section;
    }

    public AndroidElement getLiving_tempTab() {
        return living_tempTab;
    }

    public AndroidElement getLiving_cTemp() {
        return living_cTemp;
    }
}



