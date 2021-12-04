package grafanaTests;

import Utillties.CommonOps;
import Utillties.ManageDDT;
import Utillties.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import workFlows.ApiFlows;

public class GrafanaApiTest extends CommonOps {
    @Test(priority = 1,dataProvider = "data-providerApiUsers",dataProviderClass = ManageDDT.class)
    @Description("add a new users from CSV file")
    public void test01_addUser(String name, String email,String login,String password)
    {
        ApiFlows.postUser(name, email, login,password);
        Verification.verifyInt(response.getStatusCode(),200);
    }
    @Test(priority =2,description = "delete all user")
    @Description("delete all users which have been added")
    public void test03_deleteUsers()
    {
        ApiFlows.deleteUsers();
    }
    @Test(priority =3,description = "change password of user")
    @Description("chang the password of admin user")
    public void test03_changePassword()
    {
        ApiFlows.changePassword("admin","admin");
        Verification.verifyInt(response.getStatusCode(),200);
    }
    @Test(priority = 4,description = "print number of users")
    @Description("check if all users have a positive id (with softAssert)")
    public void test04_checkIfAllUsersHaveID()
    {
        checkIfAllUsersHaveID();
        Verification.verifyAssertAll();
    }
    @Test(priority = 5,dataProvider = "data-providerApiFolders",dataProviderClass = ManageDDT.class)
    @Description("add a folders from CSV file")
    public void test05_addFolders(String uid,String title)
    {
        ApiFlows.postFolder(uid,title);
        Verification.verifyInt(response.getStatusCode(),200);
    }
    @Test(priority = 6,description = "delete folder")
    @Description("delete folder by uid")
    public void test06_DeleteFolder()
    {
    ApiFlows.deleteFolder("nErXDvCkzz");
    Verification.verifyInt(response.getStatusCode(),200);
    }

}
