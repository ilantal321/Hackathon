package Utillties;

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
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import pageObjects.calculator.CalculatorPage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class CommonOps extends Base {

    @Parameters({ "PlatformName" ,"Driver"})
    @BeforeClass
    public void startSession(String platformName ,String driver) throws java.net.MalformedURLException, InterruptedException {
        if (platformName.equals("Desktop")) {
            initWindowsDriver();
        }
        else if (platformName.equals("web") ) {
            initWebDriver(driver);
        }
        else if((platformName.equals("Appium"))){
            initAndroidDriver();
        }
        else if((platformName.equals("API"))){
            initAPI();
        }
        else if((platformName.equals("Electron"))){
            initElectronDriver();
        }
        else if((platformName.equals("Database"))){
            initDataBase();
        }

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
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        Androiddriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        Androiddriver.setLogLevel(Level.INFO);
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
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    pluginsPage.getInput_searchPlugins().sendKeys(Keys.ENTER);
    screen.click(pathOfMySqlPic,50);
    Verification.verifyStrings(webDriver.getCurrentUrl(),getData("URL")+getData("URLPluginsMySql"));
}

    @Parameters({ "PlatformName" })
    @AfterClass
    public void closeSession(String platformName){
        if (platformName.equals("Desktop")) {
            windowsDriver.close();
        }
        if (platformName.equals("web")) {
            webDriver.close();
        }if (platformName.equals("Appium")) {
            Androiddriver.close();
        }
    }
    @Step
    public static void checkIfAllUsersHaveID()
    {
        response=httpRequest.get("/api/users");
        jsonPath=response.jsonPath();
        response.getBody().prettyPrint();
        Verification.verifyInt(response.getStatusCode(),200);
        softAssert=new SoftAssert();
        List<Integer> usersIsAdmin=jsonPath.getList("id");
        for (int id:usersIsAdmin)
            softAssert.assertTrue(id>0);
        softAssert.assertAll();
    }

        @Attachment(value = "Page screenshot", type = "image/png")
        public static byte[] saveScreenshot () {
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }

    public static String getData (String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./TestValues.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }


    @Step
    public static void initElectronDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\electrondriver-v3.1.2-win32-x64\\electrondriver.exe");
        opt = new ChromeOptions();
        //opt.setBinary("C:\\Automation\\TodoList-Setup.exe");
        opt.setBinary("C:\\Users\\User\\AppData\\Local\\Programs\\todolist\\Todolist.exe");
        electronDc = new DesiredCapabilities();
        electronDc.setCapability("chromeOptions", opt);
        electronDc.setBrowserName("chrome");
        webDriver = new ChromeDriver(electronDc);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions=new Actions(webDriver);
        ManagerPages.makeToDoListPage();
    }

    @Step
    public void initDataBase(){
        jdbc=new JDBC();
        jdbc.initSQLConnection();
        softAssert=new SoftAssert();
    }
}
