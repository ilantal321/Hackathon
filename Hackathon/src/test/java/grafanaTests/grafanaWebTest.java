package grafanaTests;

import Utillties.CommonOps;
import Utillties.Verification;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import workFlows.WebFlows;

import static org.testng.AssertJUnit.fail;

public class grafanaWebTest extends CommonOps {


    @Test(priority = 1,description = "login")
    @Description("login to grafana")
    public void test01_loginToGrafana() {
        WebFlows.loginToGrafana(getData("UserName"), getData("Password"));
        Verification.verifyStrings(webDriver.getTitle(), getData("HomePageTitle"));
    }

    @Test(priority = 2,description = "add user",dependsOnMethods = "test01_loginToGrafana")
    @Description("add a new user and check if it has been added")
    public void test02_addNewUser() {
        WebFlows.addUserTOGrafana(getData("NewName"),getData("NewEmail"),getData("NewUserName"),getData("NewPassword"));
        Verification.verifyElementExist(loginPage.getLabel_NewUserInTable());
    }

    @Test(priority = 3,description ="delete user",dependsOnMethods = "test02_addNewUser")
    @Description("delete user and check if it has been deleted")
    public void test03_deleteNewUser() {
        WebFlows.deleteUserInGrafana();
        Verification.verifyElementNotExist(loginPage.getLabel_NewUserInTable());
    }

    @Test(priority = 4,description = "add New Dashboard",dependsOnMethods = "test01_loginToGrafana")
    @Description("add a new dashboard and check if it has been added")
    public void test04_addNewDashboard() throws InterruptedException {
        WebFlows.dashBoardCreateAndVerify();
        Verification.verifyNotEqual(String.valueOf(dashboardPage.getDashboards_size().size()),"0");
    }

   @Test(priority = 5,description = "check plugin mySql",dependsOnMethods = "test01_loginToGrafana")
   @Description("check if plugin mySql is exists (with sikuli)")
    public void test05_checkPlugins() throws FindFailed {
        checkPlugins();
       Verification.verifyStrings(webDriver.getCurrentUrl(),getData("UL")+getData("URLPluginsMySql"));
    }

}
