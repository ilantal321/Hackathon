package Utillties;

import extensions.GrafanaUIActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    @BeforeClass
    public void startSession() {



        if (ManageDDT.getData("WebPlatform").equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        else if (ManageDDT.getData("WebPlatform").equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        else if (ManageDDT.getData("WebPlatform").equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.get(ManageDDT.getData("URL"));
        ManagerPages.makePOLoginPage();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        grafanaUIActions = new GrafanaUIActions();

        //dashboard
        ManagerPages.makeDashboardPage();
    }

        @Attachment(value = "Page Screen-Shot", type = "image/png")
        public static byte[] saveScreenshot () {
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }

}
