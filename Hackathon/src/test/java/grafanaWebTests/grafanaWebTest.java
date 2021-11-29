package grafanaWebTests;

import Utillties.CommonOps;
import Utillties.ManageDDT;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import workFlows.WorkFlow;

public class grafanaWebTest extends CommonOps {


    @Test
    public void Test01_loginToGrafana() {
        WorkFlow.loginToGrafana(ManageDDT.getData("UserName"), ManageDDT.getData("Password"));
    }

    @Test
    public void Test02_addNewUser() {
        WorkFlow.addUserTOGrafana();
    }

    @Test
    public void Test03_deleteNewUser() {
        WorkFlow.deleteUserInGrafana();
    }

    @Test
    public void test04_addNewDashboard() throws InterruptedException {
        webDriver.get("http://localhost:3000/?orgId=1");
        WorkFlow.dashobardCreateAndVerify();
    }
    /*
   @Test
    public void test05_checkPlugins() throws FindFailed {
        checkPlugins();

    }*/
}
