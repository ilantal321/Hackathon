package workFlows;
import Utillties.Base;
import Utillties.CommonOps;
import Utillties.Verification;
import extensions.ApiActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.List;
    public class ApiFlows extends CommonOps {
        @Step("add user")
        public static void postUser(String name, String email,String login,String password)
        {
            addToBodyOfRequest(new Object[][]{{"name",name},{"email",email},{"login",login},{"password",password}});
            ApiActions.makePostRequest(getData("pathPost_DeleteUser"));
            response.getBody().prettyPrint();
        }
        @Step("add folder")
        public static void postFolder(String uid, String title)
        {
            addToBodyOfRequest(new Object[][]{{"uid",uid},{"title",title}});
            ApiActions.makePostRequest(getData("pathFolder"));
            response.getBody().prettyPrint();
        }
        @Step("add folder")
        public static void changePassword(String oldPassword,String newPassword)
        {
            addToBodyOfRequest(new Object[][]{{"oldPassword",oldPassword},{"newPassword",newPassword}});
            ApiActions.makePutRequest(getData("pathChangePassword"));
            response.getBody().prettyPrint();
        }
        @Step("add folder To Body Of Request")
        public static void addToBodyOfRequest(Object[][] parameters)
        {
            param = new JSONObject();
            for(int i=0;i<parameters.length;i++) {
                param.put(parameters[i][0],parameters[i][1]);
            }
            httpRequest.body(param.toJSONString());
        }
        @Step("make delete folder")
        public static void deleteFolder(String uid)
        {
            ApiActions.makeDeleteRequest(getData("pathFolder")+uid);
            response.getBody().prettyPrint();
        }
        @Step("add folder To Body Of Request")
        public static void deleteUsers() {
            ApiActions.makeGetRequest(getData("pathGetAllUsers"));
            jsonPath = response.jsonPath();
            allUsersId = jsonPath.getList("id");
            allUsersLogin = jsonPath.getList("login");
            for (int i = 0; i < allUsersId.size(); i++) {
                if (!allUsersLogin.get(i).equals(getData("UserName"))) {//check
                    ApiActions.makeDeleteRequest(getData("pathPost_DeleteUser") + Integer.toString(allUsersId.get(i)));
                    response.getBody().prettyPrint();
                    Verification.verifySoftAssertEquals(response.getStatusCode(), 200);
                }
            }
        }


}
