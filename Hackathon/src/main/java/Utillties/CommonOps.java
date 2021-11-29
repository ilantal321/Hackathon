package Utillties;

import extensions.ExtensionGrafanaWeb;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(ManageDDT.getData("URL"));
        ManagerPages.makePOLoginPage();
        ManagerPages.makePOMenuPage();
        ManagerPages.makePOPluginsPage();
        screen=new Screen();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extensionGrafanaWeb=new ExtensionGrafanaWeb();
        actions=new Actions(webDriver);
    }
@Step("check if plugin mySql found when search it")
public void checkPlugins() throws FindFailed {
    actions.moveToElement(menuComponent.getSvg_Configuration()).click(menuComponent.getA_plugins()).build().perform();
    extensionGrafanaWeb.sendKeys(pluginsPage.getInput_searchPlugins(),"mySql");
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    pluginsPage.getInput_searchPlugins().sendKeys(Keys.ENTER);
    screen.click(pathOfMySqlPic,70);
    Verification.verifyStrings(webDriver.getCurrentUrl(),ManageDDT.getData("URL")+ManageDDT.getData("URLPluginsMySql"));


}
    @AfterClass
    public void closeSession(){
       // webDriver.close();
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

}
