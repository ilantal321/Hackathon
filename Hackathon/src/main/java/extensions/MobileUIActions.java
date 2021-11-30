package extensions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;

public class MobileUIActions {


    @Step
    public static void click(AndroidElement ele){
        ele.click();
    }

    @Step
    public static void sendkeys(AndroidElement ele,String value){
        ele.sendKeys(value);
    }


}
