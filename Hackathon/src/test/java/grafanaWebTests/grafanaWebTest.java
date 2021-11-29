package grafanaWebTests;

import Utillties.CommonOps;
import Utillties.ManageDDT;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import workFlows.WorkFlow;

public class grafanaWebTest extends CommonOps {
    @Test(priority = 0)
    public void test01_loginToGrafana(){
        WorkFlow.loginToGrafana(ManageDDT.getData("UserName"),ManageDDT.getData("Password"));
    }
    @Test(priority = 1,description = "")
    public void test02_checkPlugins() throws FindFailed {
        checkPlugins();

    }
}
