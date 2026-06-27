package ui;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.customer.SignUpPage;

public class SignUpPageTest extends BaseTest {


    private SignUpPage signup;


    @Test(priority = 1,testName = "SMK-001",description = "Verify User Registration")
    public void isSignUpPageVisible(){
        signup = hp.navigateToRegisterPage();

        Assert.assertTrue(getDriver().findElement(By.xpath("//h1[text()='Create Account']")).isDisplayed());
    }

    @Test(priority = 2,dependsOnMethods = "isSignUpPageVisible")
    public void signUpWithValidDetails(){
        signup.signUp("ValidUser","never000974@gmail.com","7900000004","cognizant","Password@123");
        WebDriverWait wait = webWait();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        Assert.assertTrue(alertText.contains("successful"));
        boolean isRedirected = wait.until(ExpectedConditions.urlContains("login"));

        Assert.assertTrue("https://maze-bank-cts.vercel.app/login".equals(getDriver().getCurrentUrl()));

    }

    @Test(priority = 3)
    public void signUpWithExistingEmail(){
        signup=hp.navigateToRegisterPage();
        String text = signup.signUpWithExistingDetails("ValidUser","never@gmail.com","8081179997","cognizant","Password@123");

        Assert.assertTrue(text.contains("already"));

    }

}
