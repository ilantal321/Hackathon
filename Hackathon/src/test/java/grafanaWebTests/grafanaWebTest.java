package grafanaWebTests;

import Utillties.CommonOps;
import Utillties.ManageDDT;
import org.testng.annotations.Test;
import workFlows.WorkFlow;

public class grafanaWebTest extends CommonOps {
    @Test
    public void Test01_loginToGrafana(){
        WorkFlow.loginToGrafana(ManageDDT.getData("UserName"),ManageDDT.getData("Password"));
    }

    @Test
    public void addNewDashboard() throws InterruptedException {
        WorkFlow.dashobardCreateAndVerify();
    }
}
