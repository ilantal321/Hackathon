package Utillties;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class ManagerPages extends CommonOps{
    @Step("make PO LoginPage")
    public static void makePOLoginPage()
    {
        loginPage= PageFactory.initElements(webDriver, LoginPage.class);
    }

    @Step("Make Dashboard Page")
    public static void makeDashboardPage()
    {
        dashboardPage= PageFactory.initElements(webDriver, DashboardPage.class);
    }
}
