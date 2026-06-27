package ui;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.LoginPage;



import java.time.Duration;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;

    @Test(priority = -1)
    public void isLoginPageVisible(){
        loginPage = hp.navigateToLoginPage();
        Assert.assertTrue(getDriver().findElement(By.xpath("//p[contains(text(),'Welcome')]")).isDisplayed());
    }



    @Test(priority = 2, testName = "SMK-002",description = "Verify User Login Functionality",dependsOnMethods = "isLoginPageVisible")
    public void loginWithValidDetails(){
        logger.info("Login With Valid Details");
        loginPage.login("lala@gmail.com","Password@123");
        WebDriverWait wait = webWait();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        Assert.assertTrue(loginPage.isLoggedIn());
        logger.info(("Ending Vaid login"));

    }

    @Test(priority = 1)
    public void loginWithInvalidDetails(){
        loginPage.login("lala@gmail.com","password@11");
        WebDriverWait wait =webWait();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertFalse(alert.getText().contains("Welcome"));
        alert.accept();


    }



}
