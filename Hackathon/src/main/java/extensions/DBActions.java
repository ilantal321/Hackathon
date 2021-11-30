package extensions;
import Utillties.CommonOps;
import io.qameta.allure.Step;

public class DBActions extends CommonOps{
    @Step
    public static String getCredentials (int num) throws InterruptedException{
        return jdbc.getCredentials().get(num);
    }

    @Step
    public static int getSizeList(){
        return jdbc.getCredentials().size();
    }
}
