package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    public WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    private By accountBtn = By.xpath("//button[@routerlink='/accounts']");
    private By transactionsBtn = By.xpath("//button[@routerlink='/transactions']");
    private By accountsInfo = By.xpath("//div[@class='account-info']");

    public AccountsPage navigateToAccounts(){
        driver.findElement(accountBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("accounts"));
        return new AccountsPage(driver);
    }

    public TransactionsPage navigateToTransactions(){
        driver.findElement(transactionsBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountsInfo));
        return new TransactionsPage(driver);
    }
}
