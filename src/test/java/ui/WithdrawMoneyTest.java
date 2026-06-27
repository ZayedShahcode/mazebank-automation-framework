package ui;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.TransactionsPage;

import java.time.Duration;

public class WithdrawMoneyTest extends BaseTest {
    DashboardPage dashboardPage;
    TransactionsPage transactionsPage;


    @Test(priority=1)
    public void navigateToTransactionsPage(){
        dashboardPage = hp.navigateToDashboardViaLogin("lala@gmail.com","Password@123");
        transactionsPage = dashboardPage.navigateToTransactions();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://maze-bank-cts.vercel.app/transactions");
    }

    @Test(priority = 2)
    public void withdrawMoney(){
        WebDriverWait wait = webWait();

        transactionsPage.withdrawMoney("1000");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        System.out.println(text);
        Assert.assertTrue(text.contains("Withdrawal successful!"));

    }
}
