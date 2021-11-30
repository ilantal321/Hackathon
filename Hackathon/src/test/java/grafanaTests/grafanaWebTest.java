package grafanaTests;

import Utillties.CommonOps;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import workFlows.WebFlows;

public class grafanaWebTest extends CommonOps {


    @Test
    public void test01_loginToGrafana() {
        WebFlows.loginToGrafana(getData("UserName"), getData("Password"));
    }

    @Test
    public void test02_addNewUser() {
        WebFlows.addUserTOGrafana(getData("NewName"),getData("NewEmail"),getData("NewUserName"),getData("NewPassword"));
    }

    @Test
    public void test03_deleteNewUser() {
        WebFlows.deleteUserInGrafana();
    }

    @Test
    public void test04_addNewDashboard() throws InterruptedException {
        WebFlows.dashBoardCreateAndVerify();
    }

   @Test
    public void test05_checkPlugins() throws FindFailed {
        checkPlugins();
    }
    @Test
    public void test06_databaseCheckAllData() throws InterruptedException {
        WebFlows.assertAll();
    }

}
