package grafanaWebTests;

import Utillties.CommonOps;
import org.testng.annotations.Test;
import workFlows.WorkFlow;

public class grafanaWebTest extends CommonOps {
    @Test
    public void Test01_loginToGrafana(){
        WorkFlow.loginToGrafana("admin","admin");
    }
}
