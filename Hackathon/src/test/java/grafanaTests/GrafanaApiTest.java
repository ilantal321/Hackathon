package grafanaTests;

import Utillties.CommonOps;
import Utillties.ManageDDT;
import org.testng.annotations.Test;
import workFlows.ApiFlows;

public class GrafanaApiTest extends CommonOps {
    @Test(priority = 1,dataProvider = "data-providerApiUsers",dataProviderClass = ManageDDT.class)
    public void test01_addUser(String name, String email,String login,String password)
    {
        ApiFlows.postUser(name, email, login,password);
    }
    @Test(priority =2,description = "change password of user")
    public void test02_changePassword()
    {
        ApiFlows.changePassword("admin","admin");
    }
    @Test(priority = 3,description = "print number of users")
    public void test03_checkIfAllUsersHaveID()
    {
        checkIfAllUsersHaveID();
    }
    @Test(priority = 4,dataProvider = "data-providerApiFolders",dataProviderClass = ManageDDT.class)
    public void test04_addFolders(String uid,String title)
    {
        ApiFlows.postFolder(uid,title);
    }
    @Test(priority = 5)
    public void test05_DeleteFolder()
    {
ApiFlows.DeleteFolder("nErXDvCkzz");
    }

}
