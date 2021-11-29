package Utillties;

import extensions.GrafanaUIActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class Base {
    protected static WebDriver webDriver;
    protected static LoginPage loginPage;
    protected static Wait wait;
    protected static GrafanaUIActions grafanaUIActions;
    protected static DashboardPage dashboardPage;

}
