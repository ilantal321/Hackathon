package Utillties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.*;
public class Verification {
    @Step("verify strings")
    public static void verifyStrings(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("verify element exist")
    public static void verifyElementExist(List<WebElement> lwe) {
        assertTrue(lwe.size() > 0);
    }

    @Step("verify element not exist")
    public static void verifyElementNotExist(List<WebElement> lwe) {
        assertTrue(lwe.size() == 0);
    }

    @Step("verify not equal")
    public static void verifyNotEqual(String actual, String expected) {
        assertNotEquals(actual, expected);
    }

}
