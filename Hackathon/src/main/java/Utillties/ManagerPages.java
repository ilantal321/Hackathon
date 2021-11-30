package Utillties;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pageObjects.gafana.DashboardPage;
import pageObjects.gafana.LoginPage;
import pageObjects.gafana.MenuComponent;
import pageObjects.gafana.PluginsPage;
import pageObjects.unitConverter.basicWeightSection;
import pageObjects.unitConverter.livingCurrencySection;
import pageObjects.unitConverter.livingTempSection;

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

    @Step("Make Dashboard Page")
    public static void makeDashboardPage()
    {
        dashboardPage= PageFactory.initElements(webDriver, DashboardPage.class);
    }

    @Step("appium")
    public static void makeAppium(){
        basicWeightSection =new basicWeightSection(driver);
    }

    @Step("appium")
    public static void AppiumLivingSection(){
        livingTempSection =new livingTempSection(driver);
    }

    @Step("appiumLivingCurrencySection")
    public static void appiumLivingCurrencySection(){
        livingCurrencySection =new livingCurrencySection(driver);
    }

}
