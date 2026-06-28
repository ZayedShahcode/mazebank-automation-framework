package pages.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AccountsPage extends BasePage {

    public WebDriver driver;

    public AccountsPage(WebDriver driver){
        this.driver=driver;
    }

    private By aadharInput = By.xpath("//input[contains(@placeholder,'Aadhar')]");
    private By panInput = By.xpath("//input[contains(@placeholder,'e.g. ABCDE1234F')]");

    private By createButton = By.xpath("//button/child::span[text()=' Create Savings Account ']/parent::button");

    public String createAccount(String aadharNumber, String panNumber) {

        type(driver,aadharInput,aadharNumber);
        type(driver,panInput,panNumber);
        click(driver,createButton);
        return handleAlerts(driver);
    }
}
