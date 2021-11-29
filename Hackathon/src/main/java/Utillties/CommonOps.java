package Utillties;

import extensions.UIActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    @BeforeClass
    public void startSession() {



        if (getData("WebPlatform").equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        else if (getData("WebPlatform").equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        else if (getData("WebPlatform").equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.get(getData("URL"));
        ManagerPages.makePOLoginPage();
        ManagerPages.makePOMenuPage();
        ManagerPages.makePOPluginsPage();
        ManagerPages.makeDashboardPage();
        screen=new Screen();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        grafanaUIActions = new UIActions();

        //dashboard
        ManagerPages.makeDashboardPage();
        grafanaUIActions=new UIActions();
        actions=new Actions(webDriver);
    }
@Step("check if plugin mySql found when search it")
public void checkPlugins() throws FindFailed {
    actions.moveToElement(menuComponent.getSvg_Configuration()).click(menuComponent.getA_plugins()).build().perform();
    grafanaUIActions.sendKeys(pluginsPage.getInput_searchPlugins(),"mySql");
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    pluginsPage.getInput_searchPlugins().sendKeys(Keys.ENTER);
    screen.click(pathOfMySqlPic,70);
    Verification.verifyStrings(webDriver.getCurrentUrl(),getData("URL")+getData("URLPluginsMySql"));


}
    @AfterClass
    public void closeSession(){
        webDriver.close();

    }

        @Attachment(value = "Page Screen-Shot", type = "image/png")
        public static byte[] saveScreenshot () {
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }

    public static String getData (String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./grafanaWebData.xml");
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
}
