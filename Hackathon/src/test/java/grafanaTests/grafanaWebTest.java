package grafanaTests;

import Utillties.CommonOps;
import org.testng.annotations.Test;
import workFlows.WebFlows;

public class grafanaWebTest extends CommonOps {


    @Test
    public void Test01_loginToGrafana() {
        WebFlows.loginToGrafana(getData("UserName"), getData("Password"));
    }

    @Test
    public void Test02_addNewUser() {
        WebFlows.addUserTOGrafana(getData("NewName"),getData("NewEmail"),getData("NewUserName"),getData("NewPassword"));
    }

    @Test
    public void Test03_deleteNewUser() {
        WebFlows.deleteUserInGrafana();
    }

    @Test
    public void test04_addNewDashboard() throws InterruptedException {
        WebFlows.dashBoardCreateAndVerify();
    }
    /*
   @Test
    public void test05_checkPlugins() throws FindFailed {
        checkPlugins();

    }*/
}
