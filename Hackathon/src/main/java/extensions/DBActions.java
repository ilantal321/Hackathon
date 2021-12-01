package extensions;
import Utillties.CommonOps;
import io.qameta.allure.Step;

public class DBActions extends CommonOps{
    @Step("get database data")
    public static String getCredentials (int num) throws InterruptedException{
        return jdbc.getCredentials().get(num);
    }

    @Step("get table size")
    public static int getSizeList(){
        return jdbc.getCredentials().size();
    }
}
