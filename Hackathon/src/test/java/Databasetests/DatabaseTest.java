package Databasetests;

import Utillties.CommonOps;
import Utillties.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import workFlows.WebFlows;

public class DatabaseTest extends CommonOps {
    @Test(priority = 1,description = "check balance")
    @Description("check all balance of teachers are over 9000 ")
    public void test01_databaseCheckAllData() throws InterruptedException {
        WebFlows.assertAll();
        Verification.verifyAssertAll();
    }
}
