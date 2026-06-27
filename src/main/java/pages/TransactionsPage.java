package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransactionsPage extends BasePage {

    public WebDriver driver;

    public TransactionsPage(WebDriver driver){
        this.driver = driver;
    }

    private By accountsInfo = By.xpath("//div[@class='account-info']");


    private By depositInput = By.xpath("//input[@data-qa='deposit-input']");
    private By depositBtn = By.xpath("//button[@data-qa='deposit-btn']");

    private By withdrawNavBtn = By.xpath("//*[contains(text(),'Withdraw') and @class='mdc-tab__text-label']");


    private By withdrawInput = By.xpath("//input[@data-qa='withdraw-input']");
    private By withdrawBtn = By.xpath("//button[@data-qa='withdraw-btn']");

    public void depositMoney(String amount){
        WebElement depositField = driver.findElement(depositInput);
        depositField.clear();
        depositField.sendKeys(amount);

        driver.findElement(depositBtn).click();
    }

    public void withdrawMoney(String amount){

        driver.findElement(withdrawNavBtn).click();
        type(driver,withdrawInput,amount);

        click(driver,withdrawBtn);

    }
}
