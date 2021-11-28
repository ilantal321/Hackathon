package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy (css = "#current-password")
    private WebElement text_password;
    @FindBy (xpath = "//*[@name='user']")
    private WebElement text_userName;
    @FindBy (css = ".css-1xivtx2-button")
    private WebElement btn_login;
    @FindBy (css = ".css-1tbo7ox-button")
    private WebElement btn_skip;

    public WebElement getBtn_skip() {
        return btn_skip;
    }

    public WebElement getText_password() {
        return text_password;
    }

    public WebElement getText_userName() {
        return text_userName;
    }

    public WebElement getBtn_login() {
        return btn_login;
    }

}
