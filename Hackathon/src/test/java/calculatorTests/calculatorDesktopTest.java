package calculatorTests;
import Utillties.CommonOps;
import Utillties.Verification;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.calculator.CalculatorPage;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.windows.WindowsDriver;
import workFlows.DesktopFlows;

import static org.testng.AssertJUnit.fail;

public class calculatorDesktopTest extends CommonOps{
    @Test(priority = 1,description = "check add function")
    @Description("check add function on calculator desktop ")
    public void Test01Add() {
        DesktopFlows.addNumbers();
        Verification.verifyStrings(calculatorPage.getBtn_Results().getText().substring(11),getData("ResultAdd"));
    }
    @Test(priority = 2,description = "check sub function")
    @Description("check sub function on calculator desktop ")
    public void Test02Sub() {
        DesktopFlows.subNumbers();
        Verification.verifyStrings(calculatorPage.getBtn_Results().getText().substring(11),getData("ResultSub"));
    }
    @Test(priority = 3,description = "check div function")
    @Description("check div function on calculator desktop ")
    public void Test03Div() {
        DesktopFlows.divNumbers();
        Verification.verifyStrings(calculatorPage.getBtn_Results().getText().substring(11),getData("ResultDiv"));
    }

    @Test(priority = 4,description = "check multi function")
    @Description("check multi function on calculator desktop ")
    public void Test04Multi() {
        DesktopFlows.mulNumbers();
        Verification.verifyStrings(calculatorPage.getBtn_Results().getText().substring(11),getData("ResultMul"));
    }

}
