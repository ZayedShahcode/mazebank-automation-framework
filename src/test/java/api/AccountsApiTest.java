package api;

import api.services.AccountsApiService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import api.models.AccountsResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class AccountsApiTest {
    AccountsApiService accountsApiService;


    Response res;
    JsonPath resBody;

    @BeforeClass
    public void login(){
        accountsApiService = new AccountsApiService();
        res = accountsApiService.accounts();
        AccountsResponse[] accountsResponse = res.as(AccountsResponse[].class);
        resBody = res.then().extract().jsonPath();


    }

    @Test
    public void verifyAccountNumber(){
        String accountNumber = res.jsonPath().getString("[0].accountNumber");
        Assert.assertTrue(accountNumber.contains("MAZE17045978"));
//        System.out.println(resBody.getList("[0]").size());
    }

    @Test
    public void verifyAccountType(){
        String accountType = resBody.getString("accountType");
        Assert.assertTrue(accountType.contains("SAVINGS"));
    }

    @Test
    public void verifyAccountStatus(){
        Assert.assertTrue(resBody.getString("active").contains("true"));
    }


}
