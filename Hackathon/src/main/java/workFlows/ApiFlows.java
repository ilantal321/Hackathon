package workFlows;
import Utillties.Base;
import Utillties.CommonOps;
import Utillties.Verification;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.Assert;
import java.awt.*;
import java.util.List;
    public class ApiFlows extends CommonOps {
        @Step("add user")
        public static void postUser(String name, String email,String login,String password)
        {
            addToBodyOfRequest(new Object[][]{{"name",name},{"email",email},{"login",login},{"password",password}});
            response=httpRequest.post("/api/admin/users");
            response.getBody().prettyPrint();
            Assert.assertEquals(response.getStatusCode(),200);
        }
        @Step("add folder")
        public static void postFolder(String uid, String title)
        {
            addToBodyOfRequest(new Object[][]{{"uid",uid},{"title",title}});
            response=httpRequest.post("/api/folders");
            response.getBody().prettyPrint();
            Verification.verifyInt(response.getStatusCode(),200);
        }
        @Step()
        public static void changePassword(String oldPassword,String newPassword)
        {
            addToBodyOfRequest(new Object[][]{{"oldPassword",oldPassword},{"newPassword",newPassword}});
            response=httpRequest.put("/api/user/password");
            response.getBody().prettyPrint();
            Verification.verifyInt(response.getStatusCode(),200);
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
        @Step("add folder To Body Of Request")
        public static void DeleteFolder(String uid)
        {
            response=httpRequest.delete("/api/folders/"+uid);
            response.getBody().prettyPrint();
            Verification.verifyInt(response.getStatusCode(),200);
        }
}
