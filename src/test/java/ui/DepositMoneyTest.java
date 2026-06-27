package ui;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.DashboardPage;
import pages.customer.TransactionsPage;

public class DepositMoneyTest extends BaseTest {

    DashboardPage dashboardPage;
    TransactionsPage transactionsPage;

    @Test(priority=1)
    public void navigateToTransactionsPage(){
        dashboardPage = hp.navigateToDashboardViaLogin("lala@gmail.com","Password@123");
        transactionsPage = dashboardPage.navigateToTransactions();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://maze-bank-cts.vercel.app/transactions");

    }

    @Test(priority = 2,dependsOnMethods = "navigateToTransactionsPage")
    public void depositMoney(){
        WebDriverWait wait = webWait();

        transactionsPage.depositMoney("1001");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        Assert.assertTrue(text.contains("Deposit successful!"));
    }

}
