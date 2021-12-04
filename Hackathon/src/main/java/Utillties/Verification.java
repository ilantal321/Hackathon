package Utillties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utillties.Base.softAssert;
import static org.testng.Assert.*;
public class Verification {

    //assert
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
    @Step("verify int")
    public static void verifyInt(int actual, int expected) {
        assertEquals(actual, expected);
    }
    @Step("verify what big")
    public static void verifyBig(int actual, int expected){
        assertTrue(actual>expected);
    }
    @Step("verify contain")
    public static void verifyContain(String name, String con){
        assertTrue(name.contains(con));
    }
    //softAssert
    @Step("verify soft assert equals int")
    public static void verifySoftAssertEquals(int actual, int expected){
        softAssert.assertEquals(actual,expected);
    }
    @Step("verify what big (soft assert)")
    public static void verifyBigSoftAssert(int actual, int expected){
        softAssert.assertTrue(actual>expected);
    }
    @Step("verify soft assert equals string")
    public static void verifySoftAssertEquals(String actual, String expected){
        softAssert.assertEquals(actual,expected);
    }
    @Step("verify soft assert equals string")
    public static void verifySoftAssertContain(String name, String con){
        softAssert.assertTrue(name.contains(con));
    }
    @Step("assert all")
    public static void verifyAssertAll() {
        softAssert.assertAll();
    }
}
