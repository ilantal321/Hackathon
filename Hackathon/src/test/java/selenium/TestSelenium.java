package selenium;

import Utillties.CommonOps;
import org.testng.annotations.Test;
import workFlows.WorkFlow;

public class TestSelenium extends CommonOps {
    @Test
    public void Test01_loginToGrafana(){
        WorkFlow.loginToGrafana("admin","admin");
    }
}
