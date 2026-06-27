package ui;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.DashboardPage;


import java.time.Duration;

public class CreateAccountTest extends BaseTest {


    AccountsPage accountsPage;
    DashboardPage dashboardPage;


    @Test(priority = 1)
    public void navigateToAccountsPage(){
        dashboardPage = hp.navigateToDashboardViaSignUp("never0008@gmail.com","8000000008");
        accountsPage = dashboardPage.navigateToAccounts();

        Assert.assertEquals(getDriver().getCurrentUrl(),"https://maze-bank-cts.vercel.app/accounts");
    }

    @Test(priority = 2,testName = "SMK-003",dependsOnMethods = "navigateToAccountsPage")
    public void createAccountViaSignUp(){
        accountsPage.createAccount("900000000004","ZZZZZ0003Z");

        WebDriverWait wait = webWait();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        Assert.assertTrue(text.contains("Savings Account created successfully!"));
    }

}
