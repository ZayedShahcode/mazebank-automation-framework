package api.services;

import io.restassured.path.json.JsonPath;
import api.payloads.LoginRequestPayload;
import io.restassured.response.Response;
import utils.UserManager;

import static io.restassured.RestAssured.given;

public class LoginApiService extends BaseService {
    LoginRequestPayload loginRequestPayload = new LoginRequestPayload("lala@gmail.com","Password@123");

    public LoginApiService(){

    }

    public Response login(){
        Response res = given()
                .header("Content-Type","application/json")
                .body(loginRequestPayload)
                .when()
                .post("/auth/login");

        userManager = res.as(UserManager.class);
//        System.out.println(userManager.getCustomerId());
        JsonPath resJson = res.then().extract().jsonPath();


        if(res.getStatusCode()==200){

            userManager.setToken(resJson.get("token"));
//            S
        }

        return res;

    }

}
