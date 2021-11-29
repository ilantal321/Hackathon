package workFlows;

import Utillties.CommonOps;
import Utillties.ManageDDT;
import Utillties.Verification;
import extensions.ExtensionGrafanaWeb;
import extensions.Extensions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageObjects.DashboardPage;

import java.security.Key;

public class WorkFlow extends CommonOps {
    @Step("Login to Grafana")
    public static void loginToGrafana(String userName, String password){
        extensionGrafanaWeb.sendKeys(loginPage.getText_userName(),userName);
        extensionGrafanaWeb.sendKeys(loginPage.getText_password(),password);
        extensionGrafanaWeb.click(loginPage.getBtn_login());
        extensionGrafanaWeb.click(loginPage.getBtn_skip());
        Verification.verifyStrings(webDriver.getTitle(), ManageDDT.getData("HomePageTitle"));
    }


    @Step("Create & verify Dashboard")
    public static void dashobardCreateAndVerify() throws InterruptedException {
        extensionGrafanaWeb.click(dashboardPage.getBtn_create_category());
        extensionGrafanaWeb.click(dashboardPage.getBtn_addPanel());
        extensionGrafanaWeb.sendKeys(dashboardPage.getBtn_chooseFromList(), "grafana");
        dashboardPage.getBtn_chooseFromList().sendKeys((Keys.RETURN));
        extensionGrafanaWeb.click(dashboardPage.getBtn_save());
        extensionGrafanaWeb.sendKeys(dashboardPage.getTxt_dashboardName(), "test_dashboard");
        extensionGrafanaWeb.click(dashboardPage.getBtn_finallySave());
        Verification.verifyNotEqual(String.valueOf(dashboardPage.getDashboards_size().size()),"0");

    }


}
