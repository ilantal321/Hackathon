package workFlows;

import Utillties.CommonOps;
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
    }

}
