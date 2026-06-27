package api;

import api.services.LoginApiService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTest {
    LoginApiService loginApiService = new LoginApiService();

    @Test
    public void login(){
        Response res = loginApiService.login();
        Assert.assertEquals(res.getStatusCode(),200);

        JsonPath p = res.then().extract().jsonPath();

        Assert.assertEquals(p.get("email"),"lala@gmail.com");
        Assert.assertEquals(p.get("role"),"CUSTOMER");




    }
}
