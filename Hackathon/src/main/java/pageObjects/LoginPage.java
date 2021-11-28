package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage {
    @FindBy (css = "#current-password")
    private WebElement text_password;
    @FindBy (xpath = "//*[@name='user']")
    private WebElement text_userName;
    @FindBy (css = ".css-1xivtx2-button")
    private WebElement btn_login;
    @FindBy (css = ".css-1tbo7ox-button")
    private WebElement btn_skip;
    @FindBy (xpath = "(//a[contains(@href,\"admin/users\")])[1]")




    private WebElement btn_users;
    @FindBy (css = ".css-aja5tg-button")
    private WebElement btn_newUser;
    @FindBy (name = "name")
    private WebElement text_newName;
    @FindBy (name = "email")
    private WebElement text_newUserEmail;
    @FindBy (name = "login")
    private WebElement text_newUserName;
    @FindBy (name = "password")
    private WebElement text_newPassword;
    @FindBy (css = ".css-aja5tg-button")
    private WebElement btn_createUser;
    @FindBy (xpath = "//*[@title=\"Tehila123\"]")
    private List <WebElement> label_NewUserInTable;



    @FindBy (css = "div.css-kdj7v3 button.css-1r3qgdo-button")
    private WebElement btn_deleteUser;
    @FindBy (css = "div.css-1pvl9up-layoutChildrenWrapper button.css-1r3qgdo-button")
    private WebElement btn_deleteUserMassage;

    public WebElement getBtn_deleteUserMassage() {
        return btn_deleteUserMassage;
    }

    public WebElement getBtn_deleteUser() {
        return btn_deleteUser;
    }
    public List<WebElement> getLabel_NewUserInTable() {
        return label_NewUserInTable;
    }

    public WebElement getBtn_createUser() {
        return btn_createUser;
    }

    public WebElement getText_newName() {
        return text_newName;
    }

    public WebElement getText_newUserEmail() {
        return text_newUserEmail;
    }

    public WebElement getText_newUserName() {
        return text_newUserName;
    }

    public WebElement getText_newPassword() {
        return text_newPassword;
    }

    public WebElement getBtn_newUser() {
        return btn_newUser;
    }

    public WebElement getBtn_users() {
        return btn_users;
    }

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
