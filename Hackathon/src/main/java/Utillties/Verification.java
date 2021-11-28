package Utillties;

import io.qameta.allure.Step;
import static org.testng.Assert.*;
public class Verification {
    @Step("verify strings")
    public static void verifyStrings(String actual,String expected){
        assertEquals(actual,expected);
    }
}
