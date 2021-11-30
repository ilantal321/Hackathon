package Utillties;

import extensions.UIActions;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.script.Screen;
import pageObjects.calculator.CalculatorPage;
import pageObjects.gafana.DashboardPage;
import pageObjects.gafana.LoginPage;
import pageObjects.gafana.MenuComponent;
import pageObjects.gafana.PluginsPage;

public class Base {
    protected static WebDriver webDriver;
    protected static LoginPage loginPage;
    protected static MenuComponent menuComponent;
    protected static PluginsPage pluginsPage;
    protected static Wait wait;
    protected static UIActions grafanaUIActions;
    protected static Actions actions;
    protected static Screen screen;
    protected static final String pathOfMySqlPic="C:\\Automation\\Hackathon\\Hackathon\\mySql.PNG";
    protected static DashboardPage dashboardPage;

    protected static WindowsDriver windowsDriver;
    protected static DesiredCapabilities capabilities;
    protected static final String calcApp = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";
    protected static CalculatorPage calculatorPage;

}
