package Utillties;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;
import pageObjects.MenuComponent;
import pageObjects.PluginsPage;

public class ManagerPages extends CommonOps{
    @Step("make PO LoginPage")
    public static void makePOLoginPage()
    {
        loginPage= PageFactory.initElements(webDriver, LoginPage.class);
    }
    @Step("make PO menuComponent")
    public static void makePOMenuPage()
    {
        menuComponent = PageFactory.initElements(webDriver, MenuComponent.class);
    }
    @Step("make PO plugins page")
    public static void makePOPluginsPage()
    {
         pluginsPage= PageFactory.initElements(webDriver, PluginsPage.class);
    }

}
