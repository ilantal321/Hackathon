package Utillties;

import extensions.ExtensionGrafanaWeb;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    @BeforeClass
    public void startSession() {
        if (ManageDDT.getData("WebPlatform").equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        if (ManageDDT.getData("WebPlatform").equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        if (ManageDDT.getData("WebPlatform").equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.get(ManageDDT.getData("URL"));
        ManagerPages.makePOLoginPage();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extensionGrafanaWeb=new ExtensionGrafanaWeb();
    }

    @AfterClass
    public void closeSession(){

        //webDriver.close();
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

}
