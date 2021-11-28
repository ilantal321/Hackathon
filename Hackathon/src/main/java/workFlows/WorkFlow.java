package workFlows;

import Utillties.CommonOps;
import Utillties.ManageDDT;
import Utillties.Verification;
import extensions.ExtensionGrafanaWeb;
import extensions.Extensions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class WorkFlow extends CommonOps {
    @Step("Login to Grafana")
    public static void loginToGrafana(String userName, String password){
        extensionGrafanaWeb.sendKeys(loginPage.getText_userName(),userName);
        extensionGrafanaWeb.sendKeys(loginPage.getText_password(),password);
        extensionGrafanaWeb.click(loginPage.getBtn_login());
        extensionGrafanaWeb.click(loginPage.getBtn_skip());
        Verification.verifyStrings(webDriver.getTitle(), ManageDDT.getData("HomePageTitle"));
    }
    @Step("add User To Grafana")
    public static void addUserTOGrafana(){
        extensionGrafanaWeb.click(loginPage.getBtn_users());
        extensionGrafanaWeb.click(loginPage.getBtn_newUser());
        extensionGrafanaWeb.sendKeys(loginPage.getText_newName(),ManageDDT.getData("NewName"));
        extensionGrafanaWeb.sendKeys(loginPage.getText_newUserEmail(),ManageDDT.getData("NewEmail"));
        extensionGrafanaWeb.sendKeys(loginPage.getText_newUserName(),ManageDDT.getData("NewUserName"));
        extensionGrafanaWeb.sendKeys(loginPage.getText_newPassword(),ManageDDT.getData("NewPassword"));
        extensionGrafanaWeb.click(loginPage.getBtn_createUser());
        Verification.verifyElementExist(loginPage.getLabel_NewUserInTable());
    }
    @Step("delete new user in Grafana")
    public static void deleteUserInGrafana(){
        extensionGrafanaWeb.click(loginPage.getLabel_NewUserInTable().get(0));
        extensionGrafanaWeb.click(loginPage.getBtn_deleteUser());
        extensionGrafanaWeb.click(loginPage.getBtn_deleteUserMassage());
        Verification.verifyElementNotExist(loginPage.getLabel_NewUserInTable());
    }
}
