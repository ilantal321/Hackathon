package pageObjects.unitConverter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class livingCurrencySection {

        private final AndroidDriver<AndroidElement> driver;

        public livingCurrencySection(AndroidDriver<AndroidElement> driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }



        @FindBy(xpath = "//*[@text='Currency']")
        public AndroidElement livingC_currency;

        @FindBy(xpath = "//*[@text='ILS' and @id='unit_kind']")
        public AndroidElement txt_ILSResult;

        @FindBy(xpath = "//*[@contentDescription='Open navigation drawer']")
        public AndroidElement btn_mainMenu;

        @FindBy(xpath = "//*[@class='android.widget.LinearLayout' and ./*[@text='32.34']]")
        public AndroidElement btn_settings;

        @FindBy(xpath = "//*[@class='android.widget.RelativeLayout' and ./*[@text='My Currency']]")
        public AndroidElement btn_currencyChange;

        @FindBy(xpath = "//*[@text='INR - Indian Rupee']")
        public AndroidElement btn_ruppeChoose;

        @FindBy(xpath = "//*[@text='INR' and @id='unit_kind']")
        public AndroidElement txt_INRResult;







    public AndroidElement getLivingC_currency() {
        return livingC_currency;
    }
    public AndroidElement getTxt_ILSResult() {
        return txt_ILSResult;
    }

    public AndroidElement getBtn_mainMenu() {
        return btn_mainMenu;
    }

    public AndroidElement getBtn_settings() {
        return btn_settings;
    }

    public AndroidElement getBtn_currencyChange() {
        return btn_currencyChange;
    }

    public AndroidElement getBtn_ruppeChoose() {
        return btn_ruppeChoose;
    }



    public AndroidElement getTxt_INRResult() {
        return txt_INRResult;
    }
}