package Utillties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import pageObjects.LoginPage;

public class Base {
    protected static WebDriver webDriver;
    protected static LoginPage loginPage;
    protected static Wait wait;
}
