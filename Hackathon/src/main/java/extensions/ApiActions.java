package extensions;

import Utillties.CommonOps;
import io.qameta.allure.Step;

public class ApiActions extends CommonOps {
    @Step("make a get Request")
    public static void makeGetRequest(String path) {
        response = httpRequest.get(path);
    }
    @Step("make a post Request")
    public static void makePostRequest(String path) {
        response = httpRequest.post(path);
    }
    @Step("make a put Request")
    public static void makePutRequest(String path) {
        response = httpRequest.put(path);
    }

    @Step("make a delete Request")
    public static void makeDeleteRequest(String path) {
        response = httpRequest.delete(path);
    }

}
