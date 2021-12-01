package Databasetests;

import Utillties.CommonOps;
import org.testng.annotations.Test;
import workFlows.WebFlows;

public class DatabaseTest extends CommonOps {
    @Test
    public void test06_databaseCheckAllData() throws InterruptedException {
        WebFlows.assertAll();
    }
}
