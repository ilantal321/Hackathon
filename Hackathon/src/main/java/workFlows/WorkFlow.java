package workFlows;

import Utillties.CommonOps;
import extensions.Extensions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class WorkFlow extends CommonOps {

    @Step("Login to Grafana")
    public static void loginToGrafana(String userName, String password){
        Extensions.sendKeys(loginPage.getText_userName(),userName);
        Extensions.sendKeys(loginPage.getText_password(),password);
        Extensions.click(loginPage.getBtn_login());
        Extensions.click(loginPage.getBtn_skip());
    }

}
