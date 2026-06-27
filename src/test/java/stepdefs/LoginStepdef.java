package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.Config;
import utilities.DriverFactory;
import utilities.DriverManager;

import java.time.Duration;


public class LoginStepdef {

    HomePage homePage;
    LoginPage loginPage;
    WebDriver driver;
    public String baseUrl ="https://maze-bank-cts.vercel.app/";

    @Before
    public void initDriver(){
        DriverManager.setDriver(DriverFactory.createDriver(Config.getBrowser(),Config.getHeadless()));

        this.driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

        homePage = new HomePage(driver);
    }


    @Given("user is on the login page")
    public void userIsOnTheLoginPage(){
        loginPage = homePage.navigateToLoginPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://maze-bank-cts.vercel.app/login");
    }

    @When("user enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email,String password){
       loginPage.enterEmail(driver,email);
       loginPage.enterPassword(driver,password);
    }

    @When("user clicks login button")
    public void userClicksLoginButton(){
        loginPage.clickLoginBtn(driver);
    }

    @Then("user handles alert")
    public void userHandlesAlert(){
        loginPage.handleAlert();
    }

    @Then("user logs into the dashboard")
    public void userLogsIntoTheDashboard(){
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @After
    public void cleanUp(){
        DriverManager.quitDriver();
    }

}
