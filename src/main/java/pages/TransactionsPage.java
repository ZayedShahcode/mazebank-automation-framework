package pages;

import org.openqa.selenium.*;
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

    private By transferNavBtn = By.xpath("//*[contains(text(),'Transfer') and @class='mdc-tab__text-label']");
    private By transferAccountInput = By.xpath("//input[@data-qa='transfer-to-input']");
    private By transferAmountInput = By.xpath("//input[@data-qa='transfer-amt-input']");
    private By transferBtn = By.xpath("//button[@data-qa='transfer-btn']");

    public void depositMoney(String amount){
        WebElement depositField = driver.findElement(depositInput);
        depositField.clear();
        depositField.sendKeys(amount);

        driver.findElement(depositBtn).click();
    }

    public void withdrawMoney(String amount){

        click(driver,withdrawNavBtn);
        type(driver,withdrawInput,amount);

        click(driver,withdrawBtn);

    }

    public void moveToTransferTab(){
        click(driver,transferNavBtn);
    }

    public void waitForAccountNumber(){
        webWait(driver).until(ExpectedConditions.visibilityOfElementLocated(accountsInfo));
    }

    public void enterAccountNumber(String accountNumber){
        type(driver,transferAccountInput,accountNumber);
    }

    public void enterAmount(String amount){
        type(driver,transferAmountInput,amount);
    }

    public void clickTransfer(){
        click(driver,transferBtn);
    }

    public String handleAlert(){
        Alert al = webWait(driver).until(ExpectedConditions.alertIsPresent());
        String text = al.getText();
        al.accept();
        return text;
    }

}
