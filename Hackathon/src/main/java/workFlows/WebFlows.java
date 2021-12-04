package workFlows;

import Utillties.CommonOps;
import Utillties.ManageDDT;
import Utillties.Verification;
import extensions.DBActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

public class WebFlows extends CommonOps {
    @Step("Login to Grafana")
    public static void loginToGrafana(String userName, String password){
        grafanaUIActions.sendKeys(loginPage.getText_userName(),userName);
        grafanaUIActions.sendKeys(loginPage.getText_password(),password);
        grafanaUIActions.click(loginPage.getBtn_login());
        grafanaUIActions.click(loginPage.getBtn_skip());
    }

    @Step("add User To Grafana")
    public static void addUserTOGrafana(String name,String email,String userName, String password){
        grafanaUIActions.click(loginPage.getBtn_users());
        grafanaUIActions.click(loginPage.getBtn_newUser());
        grafanaUIActions.sendKeys(loginPage.getText_newName(),name);
        grafanaUIActions.sendKeys(loginPage.getText_newUserEmail(),email);
        grafanaUIActions.sendKeys(loginPage.getText_newUserName(),userName);
        grafanaUIActions.sendKeys(loginPage.getText_newPassword(),password);
        grafanaUIActions.click(loginPage.getBtn_createUser());
    }
    @Step("delete new user in Grafana")
    public static void deleteUserInGrafana(){
        grafanaUIActions.click(loginPage.getBtn_users());
        grafanaUIActions.click(loginPage.getLabel_NewUserInTable().get(0));
        grafanaUIActions.click(loginPage.getBtn_deleteUser());
        grafanaUIActions.click(loginPage.getBtn_deleteUserMassage());
    }

    @Step("Create & verify Dashboard")
    public static void dashBoardCreateAndVerify() throws InterruptedException {
        webDriver.get(getData("URLDashb"));
        grafanaUIActions.click(dashboardPage.getBtn_create_category());
        grafanaUIActions.click(dashboardPage.getBtn_addPanel());
        grafanaUIActions.sendKeys(dashboardPage.getBtn_chooseFromList(), "grafana");
        dashboardPage.getBtn_chooseFromList().sendKeys((Keys.RETURN));
        grafanaUIActions.click(dashboardPage.getBtn_save());
        grafanaUIActions.sendKeys(dashboardPage.getTxt_dashboardName(), "test_dashboard");
        grafanaUIActions.click(dashboardPage.getBtn_finallySave());
    }

    @Step("Checks each teacher's balance ")
    public static void assertAll() throws InterruptedException {
        for (int i = 0; i< DBActions.getSizeList(); i++){
                Verification.verifyBigSoftAssert(Integer.parseInt(DBActions.getCredentials(i)),Integer.parseInt(getData("Balance")));
        }
    }
}
