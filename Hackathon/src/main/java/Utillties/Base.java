package Utillties;

import extensions.ExtensionGrafanaWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class Base {
    protected static WebDriver webDriver;
    protected static LoginPage loginPage;
    protected static Wait wait;
    protected static ExtensionGrafanaWeb extensionGrafanaWeb;
    protected static DashboardPage dashboardPage;

}
