package Utillties;

import extensions.ExtensionGrafanaWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.script.Screen;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.MenuComponent;
import pageObjects.PluginsPage;

public class Base {
    protected static WebDriver webDriver;
    protected static LoginPage loginPage;
    protected static MenuComponent menuComponent;
    protected static PluginsPage pluginsPage;
    protected static Wait wait;
    protected static ExtensionGrafanaWeb extensionGrafanaWeb;
    protected static Actions actions;
    protected static Screen screen;
    protected static final String pathOfMySqlPic="C:\\Automation\\Hackathon\\Hackathon\\mySql.PNG";
    protected static DashboardPage dashboardPage;

}
