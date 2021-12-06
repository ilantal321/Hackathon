package Utillties;

import extensions.ApiActions;
import extensions.UIActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static Utillties.ManageTestValuesFile.getData;

public class CommonOps extends Base {

    @Parameters({ "PlatformName" ,"Driver"})
    @BeforeClass
    public void startSession(String platformName ,String driver) throws java.net.MalformedURLException, InterruptedException {
        platformNameForSC=platformName;
        switch (platformNameForSC.toUpperCase())
        {
            case "DESKTOP":initWindowsDriver();
            break;
            case "WEB": initWebDriver(driver);
                break;
            case "APPIUM":initAndroidDriver();
                break;
            case "API":initAPI();
                break;
            case "ELECTRON":initElectronDriver();
                break;
            case "DATABASE":initDataBase();
                break;

        }
        softAssert = new SoftAssert();
    }
    @Step("API Driver")
    public void initAPI()
    {
        RestAssured.baseURI=getData("URL");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"), getData("Password"));
        httpRequest.header("Content-Type","application/json");
    }

    @Step("Open web driver")
    public void initWebDriver(String driver) throws MalformedURLException {
        if (driver.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (driver.equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (driver.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.get(getData("URL"));
        ManagerPages.makePOLoginPage();
        ManagerPages.makePOMenuPage();
        ManagerPages.makePOPluginsPage();
        ManagerPages.makeDashboardPage();
        screen = new Screen();
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        grafanaUIActions = new UIActions();

        //dashboard
        ManagerPages.makeDashboardPage();
        grafanaUIActions = new UIActions();
        actions = new Actions(webDriver);
    }
    @Step("Open windows driver")
    public void initWindowsDriver() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", calcApp);
        windowsDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        windowsDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ManagerPages.makeCalculatorPage();
        grafanaUIActions = new UIActions();
    }

    @Step("Open appium driver")
    public void initAndroidDriver() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "d030a260");
        AndroidDriver = new AndroidDriver<>(new URL(getData("URLAndroid")), dc);
        AndroidDriver.setLogLevel(Level.INFO);
        ManagerPages.makeAppium();
        ManagerPages.AppiumLivingSection();
        ManagerPages.appiumLivingCurrencySection();

    }
    @Parameters({ "PlatformName" })
    @BeforeMethod
    public void Clear(String platformName) {
        if (platformName.equals("Desktop")) {
            windowsDriver.findElement(By.xpath("//*[@AutomationId='clearButton']")).click();
        }
        else if (platformName.equals("web") ) {
            //webDriver.get(getData("URL"));
        }
    }

@Step("check if plugin mySql found when search it")
public void checkPlugins() throws FindFailed {
    webDriver.get(getData("URL"));
    actions.moveToElement(menuComponent.getSvg_Configuration()).click(menuComponent.getA_plugins()).build().perform();
    grafanaUIActions.sendKeys(pluginsPage.getInput_searchPlugins(),"mySql");
    actions.moveToElement(pluginsPage.getInput_searchPlugins()).build().perform();
    webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    pluginsPage.getInput_searchPlugins().sendKeys(Keys.ENTER);
    screen.click(getData("PathOfMySqlPic"),85);
}

    @Parameters({ "PlatformName" })
    @AfterClass
    public void closeSession(String platformName){
        if (platformName.equals("Desktop")) {
            windowsDriver.close();
        }
        else if (platformName.equals("web") || platformName.equals("Electron")) {
            webDriver.close();
        }
        else if (platformName.equals("Appium")) {
            AndroidDriver.close();
        }
        else if (platformName.equals("Database")) {
            jdbc.closeDBCon();
        }
    }


        @Attachment(value = "Page screenshot", type = "image/png")
        public static byte[] saveScreenshot () {
            if (platformNameForSC.equals("Desktop")) {
                return ((TakesScreenshot) windowsDriver).getScreenshotAs(OutputType.BYTES);
            } else if (Base.platformNameForSC.equals("Appium")) {
                return ((TakesScreenshot) AndroidDriver).getScreenshotAs(OutputType.BYTES);
            }
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }




    @Step
    public static void initElectronDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\electrondriver.exe");
        opt = new ChromeOptions();
        //opt.setBinary("C:\\Automation\\TodoList-Setup.exe");
        opt.setBinary("C:\\Users\\USER\\AppData\\Local\\Programs\\todolist\\Todolist.exe");
        electronDc = new DesiredCapabilities();
        electronDc.setCapability("chromeOptions", opt);
        electronDc.setBrowserName("chrome");
        webDriver = new ChromeDriver(electronDc);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions=new Actions(webDriver);
        ManagerPages.makeToDoListPage();
        grafanaUIActions=new UIActions();
        sizeOfTasks=0;
    }

    @Step
    public void initDataBase(){
        jdbc=new JDBC();
        jdbc.initSQLConnection();
    }

}
